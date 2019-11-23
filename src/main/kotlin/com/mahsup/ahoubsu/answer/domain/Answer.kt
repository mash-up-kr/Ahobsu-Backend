package com.mahsup.ahoubsu.answer.domain

import javax.persistence.*

@Entity
@Table(name = "answer")
class Answer(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
             var userId: Long,
             var missionId: Long,
             var imageUrl: String,
             var content: String,
             var emotionType: String,
             var emotionHexa: String,
             var date: String) {
    constructor(userId: Long, missionId: Long, imageUrl: String, content: String, emotionType: String, emotionHexa: String, date: String) :
            this(null, userId, missionId, imageUrl, content, emotionType, emotionHexa, date)
}