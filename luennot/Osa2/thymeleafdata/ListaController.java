package thymeleafdata;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListaController {
    private List<String> lista;

    public ListaController() {
        this.lista = new ArrayList<>();
        this.lista.add("Hello world!");
        this.lista.add("+[-[<<[+[--->]-[<<<]]]>>>-]>-.---.>..>.<<<<-.<+.>>>>>.>.<<.<-.");
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("lista", lista);
        return "index";
    }
}