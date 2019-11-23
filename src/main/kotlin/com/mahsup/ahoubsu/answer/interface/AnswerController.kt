package com.mahsup.ahoubsu.answer.`interface`

import com.mahsup.ahoubsu.answer.domain.Answer
import com.mahsup.ahoubsu.answer.dto.ReqCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ReqUpdateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResFetchAnswerEmotionDto
import com.mahsup.ahoubsu.answer.service.AnswerService
import com.mahsup.ahoubsu.model.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/answers")
class AnswerController(var answerService: AnswerService) {

    @PostMapping
    fun create(@RequestHeader(value = "userId") userId: Long, @RequestBody reqCreateAnswerDto: ReqCreateAnswerDto): ResponseEntity<Response<Answer>> {
        val answer = answerService.create(userId, reqCreateAnswerDto)
        val response = Response(201, null,null,answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @PutMapping("/{answerId}")
    fun update(@RequestHeader(value = "userId") userId: Long, @PathVariable(value = "answerId") answerId: Long, @RequestBody reqUpdateAnswerDto: ReqUpdateAnswerDto): ResponseEntity<Response<Answer>> {
        val answer = answerService.edit(userId, answerId, reqUpdateAnswerDto)
        val response = Response(answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("/{answerId}")
    fun fetch(@RequestHeader(value = "userId") userId: Long, @PathVariable(value = "answerId") answerId: Long): ResponseEntity<Response<ResFetchAnswerEmotionDto>> {
        val answer= answerService.fetch(userId, answerId)
        val response = Response(answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

//    @TODO:: 일주일치 data 뿌리기
//    @GetMapping("answers/week")
//    fun fetchList(@RequestHeader(value = "user_id") user_id: Long, @RequestBody resFetchAnswerListDto: ResFetchAnswerListDto): ResponseEntity<ArrayList<ResFetchAnswerListDto>> {
//        val answer = answerService.fetchList(user_id, resFetchAnswerListDto)
//        return ResponseEntity.status(HttpStatus.OK).body(answer)
//    }
}