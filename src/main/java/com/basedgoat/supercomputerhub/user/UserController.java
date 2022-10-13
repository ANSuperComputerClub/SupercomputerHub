package com.basedgoat.supercomputerhub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * The UserController contains the API routes for the User class.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    /**
     * The base mapping
     * @return a list of all the current users
     */
    @GetMapping
    public List<User> base() {
        return List.of(
                new User("arnabg", 7505009, "Password123!"),
                new User("ayush_seal", 1234567, "IamVeryCringe!")
        );
    }

    /**
     * The test page
     * @return a sample list of "hello" and "world", verifying that the server is accessible
     */
    @GetMapping(value = "test")
    public List<String> test() {
        return List.of("Hello", "World");
    }
}
