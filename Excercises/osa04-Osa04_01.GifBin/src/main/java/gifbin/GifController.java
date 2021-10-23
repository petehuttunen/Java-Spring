package gifbin;

import java.awt.print.Pageable;
import java.io.IOException;
import javax.tools.FileObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GifController {
    
    @Autowired
    GifRepository gifRepository;
        
    @GetMapping("/gifs")
    public String listAll(){
        return "redirect:/gifs/1";
    }
    
    @GetMapping(path = "/gifs/{id}", produces = "image/gif")
    public String listOne(Model model, @PathVariable Long id){
        Long count = gifRepository.count();

        model.addAttribute("count", count);
        if(id >= 1L && id <= count)
            model.addAttribute("current", id);
        if(id < count && id > 0L)
            model.addAttribute("next", id + 1);
        if(id > 1L)
            model.addAttribute("previous", id - 1);
        return "gifs";
    }
    
    @GetMapping(path = "/gifs/{id}/content", produces = "image/gif")
    @ResponseBody
    public byte[] get(Model model, @PathVariable Long id){
        return gifRepository.getOne(id).getContent();
        
    }
    
    @PostMapping("/gifs")
    public String save(@RequestParam("file") MultipartFile file) throws IOException{
        if(!file.getContentType().equals("image/gif")){
           return "redirect:/gifs";
        }
        GifObject gifobject = new GifObject();
        gifobject.setContent(file.getBytes());
        
        gifRepository.save(gifobject);
        
        return "redirect:/gifs";
    }
}
