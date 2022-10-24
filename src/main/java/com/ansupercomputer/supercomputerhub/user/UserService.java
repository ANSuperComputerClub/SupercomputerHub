package com.ansupercomputer.supercomputerhub.user;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    /**
     * The epic database that is very cool
     */
    private List<User> users;

    /**
     * Gets a list of all users
     */
    public List<User> getAllUsers() {
        return users;
    }

    /**
     * Removes any user with the id, and inserts the new user
     */
    public void insertUser(User user) {
        users.add(user);
    }

    /**
     * Get a user using its id, and returns null if not found
     */
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    /**
     * If the user is found, delete it. Returns true if deleted, false if nothing happened
     */
    public void deleteUserById(int id) {
        users = users.stream().filter(user -> user.getId() != id).toList();
    }

}
