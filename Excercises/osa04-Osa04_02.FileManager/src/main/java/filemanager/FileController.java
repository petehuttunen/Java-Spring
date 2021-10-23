package filemanager;


import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    
    @Autowired
    private FileManagerRepository fileManagerRepository;
    
    @GetMapping("/files")
    public String view(Model model){
        model.addAttribute("files", fileManagerRepository.findAll());
        return "files";
    }
    
    @GetMapping(path = "files/{id}")
    public ResponseEntity<byte[]> viewFile(@PathVariable Long id){

        FileManagerObject fmo = fileManagerRepository.getOne(id);
        
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(fmo.getContentType()));
        headers.setContentLength(fmo.getContentLength());
        headers.add("Content-Disposition", "attachment; filename=" +fmo.getName());
        
        return new ResponseEntity<>(fmo.getContent(), headers, HttpStatus.CREATED);
    }
    
    @PostMapping("/files")
    public String save(@RequestParam("file") MultipartFile file) throws IOException{

        FileManagerObject fmo = new FileManagerObject();
        
        fmo.setContentType(file.getContentType());
        fmo.setContent(file.getBytes());
        fmo.setName(file.getOriginalFilename());
        fmo.setContentLength(file.getSize());
        
        
        fileManagerRepository.save(fmo);
        
        return "redirect:/files";
    }
    
}
