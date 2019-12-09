package com.mahsup.ahoubsu.user.userService

import com.mahsup.ahoubsu.user.userService.JwtService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.UnsupportedEncodingException
import java.util.*

@Service
class JwtServiceImpl : JwtService {
    private fun generateKey(): ByteArray? {
        var key: ByteArray? = null
        try {
            key = SALT.toByteArray(charset("UTF-8"))
        } catch (e: UnsupportedEncodingException) {
            println(e.toString())
        }
        return key
    }

    override fun isUsable(jwt: String?): Boolean {
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

    override fun <T> create(key: String, data: T, subject: String?): String? {
        return Jwts.builder()
                .setHeaderParam("type", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setSubject(subject)
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .compact()
    }

    override fun get(key: String?): Map<String?, Any?>? {
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val jwt = request.getHeader("Authorization")
        var claims: Jws<Claims>? = null
        claims = try {
            Jwts.parser()
                    .setSigningKey(SALT.toByteArray(charset("UTF-8")))
                    .parseClaimsJws(jwt)
        } catch (e: Exception) {
            println(e.toString())
            throw Error()
            /*개발환경
			Map<String,Object> testMap = new HashMap<>();
			testMap.put("memberId", 2);
			return testMap;*/
        }
        return claims.body[key] as LinkedHashMap<String?, Any?>?
    }

    override val memberId: Int
        get() = this["member"]!!["memberId"] as Int

    companion object {
        private const val SALT = "luvookSecret"
    }
}