package com.mahsup.ahoubsu.user.userService

interface JwtService {
    fun <T> create(key: String, data: T, subject: String?): String?
    operator fun get(key: String?): Map<String?, Any?>?
    val memberId: Int

    fun isUsable(jwt: String?): Boolean
}