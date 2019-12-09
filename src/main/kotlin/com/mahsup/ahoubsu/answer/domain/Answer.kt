package com.mahsup.ahoubsu.answer.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "answer")
class Answer() {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        private set
    var userId: Long =0
        private set
    var missionId: Long =0
        private set
    var imageUrl: String =""
        private set
    var content: String =""
        private set
    var emotionType: String=""
        private set
    var emotionHexa: String=""
        private set
    var date: LocalDate? = null
        private set


    constructor(userId: Long, missionId: Long, imageUrl: String, content: String, emotionType: String, emotionHexa: String, date: LocalDate?) : this() {
        this.id = null;
        this.userId = userId
        this.missionId = missionId
        this.imageUrl = imageUrl
        this.content = content
        this.emotionType = emotionType
        this.emotionHexa = emotionHexa
        this.date = date
    }


    fun updateInfo(imageUrl: String,
                   content: String,
                   emotionType: String,
                   emotionHexa: String) {
        this.imageUrl = imageUrl
        this.content = content
        this.emotionHexa = emotionHexa
        this.emotionType = emotionType
    }
}