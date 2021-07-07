package uudelleenohjaus;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectOnPostController {

    private String message;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @PostMapping("/")
    public String post(@RequestParam String content) {
        this.message = content;
        return "redirect:/";
    }
}
