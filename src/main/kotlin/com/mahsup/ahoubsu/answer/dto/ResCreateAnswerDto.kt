package com.mahsup.ahoubsu.answer.dto

data class ResCreateAnswerDto(
        var id : Long?,
        var missionId: Long,
        var imageUrl: String,
        var content: String,
        var emotionType: String,
        var emotionHexa: String
)