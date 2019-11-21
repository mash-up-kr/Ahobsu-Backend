package com.mahsup.ahoubsu.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class UserController {
    @GetMapping
    fun get(): String {
        return "test success"
    }
}