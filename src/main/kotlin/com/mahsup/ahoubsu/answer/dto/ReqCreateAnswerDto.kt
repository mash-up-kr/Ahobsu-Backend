package com.mahsup.ahoubsu.answer.dto

data class ReqCreateAnswerDto(
        var missionId:Long,
        var imageUrl: String,
        var content: String,
        var emotionType: String,
        var emotionHexa: String
)