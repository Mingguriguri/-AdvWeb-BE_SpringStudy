package gcu.msa.restpost.controller;


import gcu.msa.restpost.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Tag(name="gcu swagger", description = "gcu management APIs")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK!!"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST!!"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND!!"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR!!")
})
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
