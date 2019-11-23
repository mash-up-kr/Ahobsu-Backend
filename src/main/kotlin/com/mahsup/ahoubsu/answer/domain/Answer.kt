package com.mahsup.ahoubsu.answer.domain

import org.springframework.data.annotation.Id
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Entity
@Table(name = "answer")
class Answer(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
             var user_id: Long,
             var mission_id: Long,
             var image_url: String,
             var content: String,
             var emotionType: String,
             var emotionHexa: String,
             var date: String) {
    constructor(user_id: Long, mission_id: Long, image_url: String, content: String, emotionType: String, emotionHexa: String, date: String) :
            this(null, user_id, mission_id, image_url, content, emotionType, emotionHexa, date)
}
