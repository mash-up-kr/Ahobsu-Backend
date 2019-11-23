package com.mahsup.ahoubsu.answer.dto

data class ResFetchAnswerListDto(
        var answerId:Long,
        var emotionType: String,
        var emotionHexa: String,
        var date: String
)