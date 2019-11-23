package com.mahsup.ahoubsu.user.service

import com.mahsup.ahoubsu.user.domain.User
import com.mahsup.ahoubsu.user.domain.UserRepository
import com.mahsup.ahoubsu.user.dto.ReqSignIndto
import org.springframework.stereotype.Service

@Service
class UserService (val userRepository: UserRepository){
    fun signIn(reqSignInDto: ReqSignIndto): User? {
        val user = User(reqSignInDto.email ,reqSignInDto.gender ,reqSignInDto.nickname ,reqSignInDto.snsType ,reqSignInDto.snsId ,reqSignInDto.refreshDate ,reqSignInDto.birthday ,reqSignInDto.refreshToken)
        return userRepository.save(user)
    }
}

