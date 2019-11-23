package com.mahsup.ahoubsu.user.`interface`

import com.mahsup.ahoubsu.model.Response
import com.mahsup.ahoubsu.user.domain.User
import com.mahsup.ahoubsu.user.dto.ReqSignIndto
import com.mahsup.ahoubsu.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController(var userService: UserService) {

    @PostMapping("/sign-in")
    fun signIn(@RequestBody reqSignInDto: ReqSignIndto): ResponseEntity<Response<User>> {
        val user = userService.signIn(reqSignInDto)
        val response = Response(200, null, "",  user )
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}