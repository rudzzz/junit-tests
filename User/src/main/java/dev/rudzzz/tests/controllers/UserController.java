package dev.rudzzz.tests.controllers;

import dev.rudzzz.tests.entities.User;
import dev.rudzzz.tests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public List<User> create(@RequestBody User user){
        return userService.create(user);
    }
}
