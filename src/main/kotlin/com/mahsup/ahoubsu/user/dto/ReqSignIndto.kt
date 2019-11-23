package com.mahsup.ahoubsu.user.dto

import java.util.*

data class ReqSignUpDto(
        var email: String,
        var gender: String,
        var nickname: String,
        var snstype: String,
        var birthday: Date)