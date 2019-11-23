package com.mahsup.ahoubsu.answer.dto

import java.sql.Date
import java.time.LocalDate

data class ResFetchAnswerEmotionDto(
        var answerId:Long,
        var emotionType: String,
        var emotionHexa: String,
        var date: LocalDate?
)