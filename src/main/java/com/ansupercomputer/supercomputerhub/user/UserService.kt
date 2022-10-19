package com.ansupercomputer.supercomputerhub.user

import org.springframework.stereotype.Component

@Component
class UserService {
    private val users = mutableListOf<User>()

    fun getAllUsers(): List<User> {
        return users.toList()
    }

    fun insertUser(user: User) {
        users.add(user)
    }

    fun getUserById(id: Int): User? {
        for (user in users) {
            if(user.id == id) {
                return user
            }
        }
        return null
    }

    fun deleteUserById(id: Int) {
        users.removeIf { user -> user.id == id }
    }

}
