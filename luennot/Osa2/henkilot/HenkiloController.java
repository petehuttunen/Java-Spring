package henkilot;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HenkiloController {
    private List<Henkilo> henkilot;

    public HenkiloController() {
        this.henkilot = new ArrayList<>();
        this.henkilot.add(new Henkilo("James Gosling"));
        this.henkilot.add(new Henkilo("Martin Odersky"));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list", henkilot);
        return "index";
    }
    
    @PostMapping("/")
    public String post(@RequestParam String nimi) {
        System.out.println(nimi);
        return "index";
    }
}
