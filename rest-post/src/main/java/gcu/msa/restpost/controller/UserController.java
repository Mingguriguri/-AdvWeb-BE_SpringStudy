package gcu.msa.restpost.controller;


import gcu.msa.restpost.domain.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Tag(name="gcu swagger", description = "gcu management APIs")
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
