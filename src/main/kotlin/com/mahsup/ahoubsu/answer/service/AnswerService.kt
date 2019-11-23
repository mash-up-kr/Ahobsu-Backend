package com.mahsup.ahoubsu.answer.service

import com.mahsup.ahoubsu.answer.domain.Answer
import com.mahsup.ahoubsu.answer.domain.AnswerRepository
import com.mahsup.ahoubsu.answer.dto.ReqCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ReqUpdateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResFetchAnswerEmotionDto
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AnswerService(val answerRepository: AnswerRepository) {
    fun create(userId: Long, reqCreateAnswerDto: ReqCreateAnswerDto): Answer {
        val answer = Answer(userId, reqCreateAnswerDto.missionId, reqCreateAnswerDto.imageUrl, reqCreateAnswerDto.content, reqCreateAnswerDto.emotionType, reqCreateAnswerDto.emotionHexa, LocalDate.now())
        return answerRepository.save(answer)
    }

    fun edit(userId: Long, answerId: Long, reqUpdateAnswerDto: ReqUpdateAnswerDto): Answer {

        val answer = answerRepository.findById(answerId).orElseThrow { RuntimeException() }

        reqUpdateAnswerDto.imageUrl.let {
            answer.imageUrl = it
        }
        reqUpdateAnswerDto.content.let {
            answer.content = it
        }
        reqUpdateAnswerDto.emotionType.let {
            answer.emotionType = it
        }
        reqUpdateAnswerDto.emotionHexa.let {
            answer.emotionHexa = it
        }
        return answer
    }

    fun fetch(userId: Long, answerId: Long): ResFetchAnswerEmotionDto {
        val answer = answerRepository.findById(answerId).orElseThrow { RuntimeException() }
        return ResFetchAnswerEmotionDto(answerId, answer.emotionType, answer.emotionHexa, answer.date)

    }
//    fun fetchList(userId: Long, resFetchAnswerListDto: ResFetchAnswerListDto): ArrayList<ResFetchAnswerListDto> {
//        val comment= answerRepository.findById(userId).orElseThrow { RuntimeException() }
//        return ResFetchAnswerListDto(answerId,comment.emotionType,comment.emotionHexa,comment.date)
//
//    }

}