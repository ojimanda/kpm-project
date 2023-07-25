package id.yozi.kpmservice.controller;


import id.yozi.kpmservice.model.User;
import id.yozi.kpmservice.model.dto.LoginRequest;
import id.yozi.kpmservice.model.dto.LoginResponse;
import id.yozi.kpmservice.model.dto.ResponseTemplate;
import id.yozi.kpmservice.model.dto.UserDTO;
import id.yozi.kpmservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTemplate<UserDTO> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplate<UserDTO> deleteUser(@PathVariable(name = "email") String email) {
        return userService.deleteUser(email);
    }

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseTemplate<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }
}
