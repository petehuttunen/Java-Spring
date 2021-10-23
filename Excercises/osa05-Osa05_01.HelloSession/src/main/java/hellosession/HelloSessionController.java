package hellosession;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSessionController {
    
    @RequestMapping("*")
    @ResponseBody
    public String sayHello(HttpSession session) {

       // if(!session.isNew()) { 
       // tai
          if(session.getAttribute("seen-before") != null) {
            return "Hello again!";
        } 
        session.setAttribute("seen-before", "yes");
        return "Hello there!";
    }
}
