package com.mahsup.ahoubsu.user.`interface`

import com.mahsup.ahoubsu.user.userService.JwtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class UserController(val jwtService: JwtService) {
    @GetMapping
    fun signin(): String? {
        val token = jwtService.create("y", "yuchoco", null)
        return token
    }
    @GetMapping("/token")
    fun signin(@RequestHeader(value = "token") token: String): String {
        val value = jwtService.get(token)
        return value.toString()
    }
}