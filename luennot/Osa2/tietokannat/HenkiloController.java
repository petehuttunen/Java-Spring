package tietokannat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HenkiloController {

    @Autowired
    private HenkiloRepository henkiloRepository;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list", henkiloRepository.findAll());
        return "henkilot"; // tässä oletetaan erillinen tiedosto henkilot.html
    }

    @PostMapping("/")
    public String create(@RequestParam String nimi) {
        henkiloRepository.save(new Henkilo(nimi));
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable Long id) {
        model.addAttribute("henkilo", henkiloRepository.getOne(id));
        return "henkilo";
    }
}