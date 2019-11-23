package com.mahsup.ahoubsu.answer.`interface`

import com.mahsup.ahoubsu.answer.domain.Answer
import com.mahsup.ahoubsu.answer.dto.RepCreateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ReqUpdateAnswerDto
import com.mahsup.ahoubsu.answer.dto.ResFetchAnswerListDto
import com.mahsup.ahoubsu.answer.service.AnswerService
import com.mahsup.ahoubsu.model.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController("/")
class AnswerController(var answerService: AnswerService) {

    @PostMapping("/missions/answer")
    fun create(@RequestHeader(value = "user_id") user_id: Long, @RequestBody reqCreateAnswerDto: RepCreateAnswerDto): ResponseEntity<Response<Answer>> {
        val answer = answerService.create(user_id, reqCreateAnswerDto)
        val response = Response(200, null, "", answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @PutMapping("/answers/{answer_id}")
    fun update(@RequestHeader(value = "user_id") user_id: Long, @PathVariable(value = "answer_id") answerId: Long, @RequestBody reqUpdateAnswerDto: ReqUpdateAnswerDto): ResponseEntity<Response<Answer>> {
        val answer = answerService.edit(user_id, answerId, reqUpdateAnswerDto)
        val response = Response(200, null, "", answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("answers/{answer_id}")
    fun fetch(@RequestHeader(value = "user_id") user_id: Long, @PathVariable(value = "answer_id") answerId: Long): ResponseEntity<Response<ResFetchAnswerListDto>> {
        val answer= answerService.fetch(user_id, answerId)
        val response = Response(200, null, "", answer)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

//    @GetMapping("answers/week")
//    fun fetchList(@RequestHeader(value = "user_id") user_id: Long, @RequestBody resFetchAnswerListDto: ResFetchAnswerListDto): ResponseEntity<ArrayList<ResFetchAnswerListDto>> {
//        val answer = answerService.fetchList(user_id, resFetchAnswerListDto)
//        return ResponseEntity.status(HttpStatus.OK).body(answer)
//    }
}