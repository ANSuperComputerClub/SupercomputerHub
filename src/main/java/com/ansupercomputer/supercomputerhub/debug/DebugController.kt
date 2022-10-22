package com.ansupercomputer.supercomputerhub.debug

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["debug"])
class DebugController {
    @GetMapping
    fun testRoute(): String {
        return " I am based "
    }
}
