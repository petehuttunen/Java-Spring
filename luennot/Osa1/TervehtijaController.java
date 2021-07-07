package parametrit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TervehtijaController {

    @GetMapping("/hei")
    @ResponseBody
    public String tervehdi(@RequestParam String nimi) {
        return "Hei " + nimi + ", mitä kuuluu?";
    }
}