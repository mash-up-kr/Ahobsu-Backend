package com.mahsup.ahoubsu.user.`interface`

import com.mahsup.ahoubsu.user.userService.JwtServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse


@RestController("/")
class UserController(val jwtService: JwtServiceImpl) {
    @GetMapping
    fun signin(): String? {
        val token = jwtService.create("y", "yuchoco", null)
        return token
    }
    @GetMapping("/token")
    fun signin(@RequestHeader(value = "token") token: String): Map<String?, Any?>? {
        val token = jwtService.get("y")
        return token
    }
}