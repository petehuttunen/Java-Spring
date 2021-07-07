package heiMaailma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PolkuController {
	@Controller
	public class PolkuController {

	    @GetMapping("/path")
	    @ResponseBody
	    public String path() {
	        return "Polku (path)";
	    }

	    @GetMapping("/route")
	    @ResponseBody
	    public String route() {
	        return "Polku (route)";
	    }

	    @GetMapping("/trail")
	    @ResponseBody
	    public String trail() {
	        return "Polku (trail)";
	    }
	}
}
