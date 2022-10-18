package com.basedgoat.supercomputerhub.user;

import com.basedgoat.supercomputerhub.exception.AuthenticationException;
import com.basedgoat.supercomputerhub.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     *
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
    @GetMapping(value = "find/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return service.getUserById(id);
    }


    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody User newUser) {
        return service.addUser(newUser);
    }

    @PostMapping(value = "login")
    @ResponseBody
    public User login(@RequestBody int studentId, @RequestBody String password) throws UserNotFoundException, AuthenticationException {
        return service.authenticateUser(studentId, password);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(UserNotFoundException error) {
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
