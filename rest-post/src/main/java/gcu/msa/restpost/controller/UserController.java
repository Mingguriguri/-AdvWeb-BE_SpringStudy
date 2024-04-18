package gcu.msa.restpost.controller;


import gcu.msa.restpost.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @PostMapping("/user")
    public ResponseEntity<String> user(@RequestBody User user){ // User객체를 RequetBodyt로 받을거임
        User inUser = new User();
        inUser.setId(user.getId());
        inUser.setName(user.getName());

        return ResponseEntity.ok(inUser.toString());
    }

}
