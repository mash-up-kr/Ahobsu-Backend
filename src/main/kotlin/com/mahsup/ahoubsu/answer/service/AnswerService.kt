package com.mahsup.ahoubsu.answer.service

import com.mahsup.ahoubsu.answer.domain.Answer
import com.mahsup.ahoubsu.answer.domain.AnswerRepository
import com.mahsup.ahoubsu.answer.dto.RepCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ReqUpdateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResFetchAnswerListDto
import org.springframework.stereotype.Service

@Service
class AnswerService(val answerRepository: AnswerRepository) {
    fun create(userId:Long,reqCreateAnswerDto: RepCreateAnswerDto): Answer {
        val comment = Answer(userId,reqCreateAnswerDto.missionId, reqCreateAnswerDto.imageUrl, reqCreateAnswerDto.content, reqCreateAnswerDto.emotionType, reqCreateAnswerDto.emotionHexa, reqCreateAnswerDto.date)
        return answerRepository.save(comment)
    }

    fun edit(userId: Long, answerId: Long, reqUpdateAnswerDto: ReqUpdateAnswerDto): Answer {

        val comment= answerRepository.findById(answerId).orElseThrow { RuntimeException() }

        reqUpdateAnswerDto.imageUrl.let{
            comment.imageUrl=it
        }
        reqUpdateAnswerDto.content.let{
            comment.content=it
        }
        reqUpdateAnswerDto.emotionType.let{
            comment.emotionType=it
        }
        reqUpdateAnswerDto.emotionHexa.let{
            comment.emotionHexa=it
        }
        reqUpdateAnswerDto.date.let{
            comment.date=it
        }

        return comment
    }

    fun fetch(userId: Long, answerId: Long): ResFetchAnswerListDto {
        val comment= answerRepository.findById(answerId).orElseThrow { RuntimeException() }
        return ResFetchAnswerListDto(answerId,comment.emotionType,comment.emotionHexa,comment.date)

    }
//    fun fetchList(userId: Long, resFetchAnswerListDto: ResFetchAnswerListDto): ArrayList<ResFetchAnswerListDto> {
//        val comment= answerRepository.findById(userId).orElseThrow { RuntimeException() }
//        return ResFetchAnswerListDto(answerId,comment.emotionType,comment.emotionHexa,comment.date)
//
//    }

}