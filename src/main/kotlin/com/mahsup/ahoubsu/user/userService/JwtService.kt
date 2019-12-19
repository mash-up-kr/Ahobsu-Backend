package com.mahsup.ahoubsu.user.userService

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import java.io.UnsupportedEncodingException

@Service
class JwtService() {
    private fun generateKey(): ByteArray? {
        var key: ByteArray? = null
        try {
            key = SALT.toByteArray(charset("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            println(e.toString())
        }
        return key
    }

    fun isUsable(jwt: String?): Boolean {
        return try {
            val claims = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(jwt)
            true
        } catch (e: Exception) {
            println(e.toString())
            throw Error()
            /*개발환경!!!
			 * return false;*/
        }
    }

    fun <T> create(key: String, data: T, subject: String?): String? {
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setSubject(subject)
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .compact()
    }

    fun get(key: String?): Any? {
        var claims: Jws<Claims>? = null
        claims = try {
            Jwts.parser()
                    .setSigningKey(SALT.toByteArray(charset("UTF-8")))
                    .parseClaimsJws(key)
        } catch (e: Exception) {
            println(e.toString())
            throw Error()
            /*개발환경
			Map<String,Object> testMap = new HashMap<>();
			testMap.put("memberId", 2);
			return testMap;*/
        }
        println(claims.body["y"])
        return  claims.body["y"]
    }

    companion object {
        private const val SALT = "yuchoco"
    }
}