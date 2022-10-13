package com.basedgoat.supercomputerhub.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The UserController contains the API routes for the User class.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    /**
     * This is called dependency injection. It is very based
     */

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * The base mapping
     * @return a list of all the current users
     */
    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return service.getUsers();
    }

    /**
     * Returns a user by their id
     */
    @GetMapping(value =  "find")
    @ResponseBody
    public User getUserById(@RequestParam Long id) {
        try {
            return service.getUserById(id);
        } catch (UserNotFoundException e) {
            return null;
        }
    }


    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User newUser) {
        return service.addUser(newUser);
    }

    @PostMapping(value = "login")
    @ResponseBody
    public User login(@RequestBody String username, @RequestBody int studentId, @RequestBody String password) {
        
    }

}
