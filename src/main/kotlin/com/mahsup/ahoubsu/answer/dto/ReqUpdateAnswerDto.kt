package com.mahsup.ahoubsu.answer.dto

data class ReqUpdateAnswerDto(
        var imageUrl: String,
        var content: String,
        var emotionType: String,
        var emotionHexa: String,
        var date: String
)