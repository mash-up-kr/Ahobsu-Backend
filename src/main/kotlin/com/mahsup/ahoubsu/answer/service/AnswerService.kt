package com.mahsup.ahoubsu.answer.service

import com.mahsup.ahoubsu.answer.domain.Answer
import com.mahsup.ahoubsu.answer.domain.AnswerRepository
import com.mahsup.ahoubsu.answer.dto.ReqCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ReqUpdateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResFetchAnswerEmotionDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class AnswerService(val answerRepository: AnswerRepository) {
    fun create(userId: Long, reqCreateAnswerDto: ReqCreateAnswerDto): ResCreateAnswerDto {
        val answer = Answer(userId, reqCreateAnswerDto.missionId, reqCreateAnswerDto.imageUrl, reqCreateAnswerDto.content, reqCreateAnswerDto.emotionType, reqCreateAnswerDto.emotionHexa, LocalDate.now())
        answerRepository.save(answer)
        val resCreateAnswerDto = ResCreateAnswerDto(answer.id, answer.missionId, answer.imageUrl, answer.content, answer.emotionType, answer.emotionHexa)
        return resCreateAnswerDto
    }

    @Transactional
    fun edit(userId: Long, answerId: Long, reqUpdateAnswerDto: ReqUpdateAnswerDto): ResCreateAnswerDto {
        val answer = answerRepository.findById(answerId).orElseThrow { RuntimeException() }
        answer.updateInfo(reqUpdateAnswerDto.imageUrl, reqUpdateAnswerDto.content, reqUpdateAnswerDto.emotionType, reqUpdateAnswerDto.emotionHexa)
        val resCreateAnswerDto = ResCreateAnswerDto(answer.id, answer.missionId, answer.imageUrl, answer.content, answer.emotionType, answer.emotionHexa)
        return resCreateAnswerDto
    }

    fun fetch(userId: Long, answerId: Long): ResFetchAnswerEmotionDto {
        val answer = answerRepository.findById(answerId).orElseThrow { RuntimeException() }
        return ResFetchAnswerEmotionDto(answerId, answer.emotionType, answer.emotionHexa, answer.date)
    }
}