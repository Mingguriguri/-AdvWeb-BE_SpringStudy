package gcu.backend.backend.backendproxy;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class CorsController {

    @GetMapping(value="/non-cors")
    public String nonCors(){
        System.out.println("Non-cors");
        return "Non-cors";
    }

    @CrossOrigin("http://localhost:3000")
    @GetMapping(value="/cors")
    public String cors(){
        System.out.println("Cors");
        return "Cors";
    }
}
