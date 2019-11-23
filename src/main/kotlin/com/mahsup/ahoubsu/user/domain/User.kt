package com.mahsup.ahoubsu.user.domain

import javax.persistence.*

@Entity
@Table(name = "users")
class User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
           var email: String,
           var gender: String,
           var nickname: String,
           var snsType: String,
           var snsId: String,
           var refreshDate: String,
           var birthday: String,
           var refreshToken: String) {
    constructor(email: String, gender: String, nickname: String, snsType: String, snsId: String, refreshDate: String, birthday: String, refreshToken: String) :
            this(null, email, gender, nickname, snsType, snsId, refreshDate, birthday, refreshToken)
}
