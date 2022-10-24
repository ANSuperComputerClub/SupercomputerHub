package com.ansupercomputer.supercomputerhub.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> listUsers() {
        return service.getAllUsers();
    }

    @GetMapping(value = "{id}")
    public User getUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        service.insertUser(user);
    }

    @PostMapping(value = "delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
    }
}
