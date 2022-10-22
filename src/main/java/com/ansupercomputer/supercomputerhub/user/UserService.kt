package com.ansupercomputer.supercomputerhub.user

import org.springframework.stereotype.Component

@Component
class UserService {
    /**
     * The epic database that is very cool
     */
    private val users = mutableListOf<User>()

    /**
     * Gets a list of all users
     */
    fun getAllUsers(): List<User> {
        return users.toList()
    }

    /**
     * Removes any user with the id, and inserts the new user
     */
    fun insertUser(user: User): Boolean {
        val flag = users.removeIf { user_ -> user_.id == user.id }
        users.add(user)
        return !flag
    }

    /**
     * Get a user using its id, and returns null if not found
     */
    fun getUserById(id: Int): User? {
        return users.find { user -> user.id == id }
    }

    /**
     * If the user is found, delete it. Returns true if deleted, false if nothing happened
     */
    fun deleteUserById(id: Int): Boolean {
        return users.removeIf { user -> user.id == id }
    }

}
