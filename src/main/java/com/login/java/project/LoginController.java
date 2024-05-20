package com.login.java.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("users")
@RestController
public class LoginController {

    @Autowired
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @PostMapping("login")
    public String login(@RequestBody User user) {
        return loginService.authenticate(user.getUsername(), user.getPassword());
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return loginService.getUserById(id);
    }

    @PutMapping("{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return loginService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id) {
        return loginService.deleteUser(id);
    }

    @PostMapping()
    public String createUser(@RequestBody User user) {
        return loginService.createUser(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return loginService.getAllUsers();
    }
}
