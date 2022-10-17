package com.basedgoat.supercomputerhub.user;

import com.basedgoat.supercomputerhub.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Contains the business logic of the application
 */
@Component
public class UserService {
    /**
     * Look at the world's greatest database to ever exist!
     */
    private final List<User> users = List.of(
            new User("arnabg", 7505009, "Password123!"),
            new User("ayush_seal", 1234567, "IamVeryCringe!")
    );
    /**
     * Grabs the current list of users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Finds a user in the "database" based on it's id
     */
    public User getUserById(Long id) throws UserNotFoundException {
        for(User user: users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    /**
     * Finds a user in the "database" based on its student id
     */
    public User getUserByStudentId(int id) throws UserNotFoundException {
        for(User user: users) {
            if(user.getStudentId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    /**
     * Creates a user and adds it to the "database"
     */
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    /*
    Verifies the password for a given user id
     */
    public User authenticateUser(int studentId, String password) throws UserNotFoundException {
        var user = getUserByStudentId(studentId);
        // This will change when we do hashing. Likley an argon or a bcrypt solution
        if(user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
