package com.ansupercomputer.supercomputerhub.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["user"])
class UserController (@Autowired private val service: UserService){

    @GetMapping
    fun listUsers(): List<User> {
        return service.getAllUsers()
    }

    @GetMapping(value = ["{id}"])
    fun getUser(@PathVariable id: Int): User? {
        return service.getUserById(id)
    }


}
