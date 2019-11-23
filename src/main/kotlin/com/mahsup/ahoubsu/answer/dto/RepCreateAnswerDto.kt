package com.mahsup.ahoubsu.answer.dto

import java.time.LocalDate

data class RepCreateAnswerDto(
        var missionId:Long,
        var imageUrl: String,
        var content: String,
        var emotionType: String,
        var emotionHexa: String,
        var date: LocalDate
)