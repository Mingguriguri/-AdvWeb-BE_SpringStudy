package gcu.backend.dockermyname.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NameController {
    @GetMapping("/myname")
    public String getMyName(){
        return "My name is Minjeong Kim";
    }
}
