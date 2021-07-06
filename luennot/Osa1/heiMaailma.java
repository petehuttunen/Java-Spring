package heimaailma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HeiMaailmaController {

    @GetMapping("*")
    @ResponseBody
    public String home() {
        return "Hei Maailma!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HeiMaailmaController.class, args);
    }
}
