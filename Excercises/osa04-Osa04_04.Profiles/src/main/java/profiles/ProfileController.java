package profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProfileController {

    @Autowired
    private Environment env;
    
    //@Value("${spring.profiles.active}")
    //private String activeProfile;

    @ResponseBody
    @GetMapping("/profile")
    public String getProfile() {
        return env.getActiveProfiles()[0];
    }

    public String home() {
        return "index";
    }

}
