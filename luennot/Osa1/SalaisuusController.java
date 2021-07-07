package parametrit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalaisuusController {

    @GetMapping("/salaisuus")
    @ResponseBody
    public String vastaa(@RequestParam String eka,
                         @RequestParam String toka,
                         @RequestParam String kolmas) {
        return "eka: " + eka + ", toka: " + toka + ", kolmas: " + kolmas;
    }
}
