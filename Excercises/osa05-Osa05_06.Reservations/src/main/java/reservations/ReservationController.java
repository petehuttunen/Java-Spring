package reservations;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/reservations")
    public String getReservations(Model model){
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }
    
    @PostMapping("/reservations")
    public String addReservation(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationFrom,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationTo) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.isAuthenticated()){
            return "redirect:/login";
        }
        
        List<Reservation> reservations = reservationRepository.findAll();
        
        for(Reservation rese : reservations) {
            if(rese.getReservationFrom().isBefore(reservationTo) && reservationFrom.isBefore(rese.getReservationTo() ) ) {
                return "redirect:/reservations";
            }
        }
        
        String username = auth.getName();
        
        Account account = accountRepository.findByUsername(username);
        Reservation reservation = new Reservation();
        reservation.setReservationFrom(reservationFrom);
        reservation.setUser(account);
        reservation.setReservationTo(reservationTo);
        reservationRepository.save(reservation);
          
        return "redirect:/reservations";
    }

}
