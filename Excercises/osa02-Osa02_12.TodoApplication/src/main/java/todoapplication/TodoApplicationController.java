package todoapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoApplicationController {

    @Autowired 
    private ItemRepository itemrepository; 
    
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("items", itemrepository.findAll());
        return "index";
    }
    
    @PostMapping("/")
    public String create(@RequestParam String name){
        itemrepository.save(new Item(name, 0));
        return "redirect:/";
    }
    
    @GetMapping("/{id}")
    public String todo(Model model, @PathVariable Integer id){
        Item haettu = itemrepository.getOne(id);
        haettu.setChecked(haettu.getChecked() +1);
        itemrepository.save(haettu);
        model.addAttribute("item", haettu);
        return ("todo");
    }
    
}
