package parametrit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PyyntoParametrienNimetController {

    @GetMapping("/nimet")
    @ResponseBody
    public String nimet(@RequestParam Map<String, String> parametrit) {
        return parametrit.keySet().toString();
    }
    
    @GetMapping("/tervehdi")
    @ResponseBody
    public String tervehdi(@RequestParam String nimi, @RequestParam Integer ika) {
        return "Hei " + nimi + ", olet " + ika + " vuotta vanha.";
    }
}
