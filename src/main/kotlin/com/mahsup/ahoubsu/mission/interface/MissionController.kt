package com.mahsup.ahoubsu.mission.`interface`

import com.mahsup.ahoubsu.mission.dto.ReqCreateMissionDto
import com.mahsup.ahoubsu.mission.dto.ResMissionDto
import com.mahsup.ahoubsu.mission.service.MissionService
import com.mahsup.ahoubsu.model.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/missions")
class MissionController(val missionService: MissionService) {
    @GetMapping
    fun fetch(): ResponseEntity<Response<MutableList<ResMissionDto>>> {
        val missions = missionService.fetch()
        val response = Response(200, "", "", missions)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
    @PostMapping
    fun create(@RequestBody reqCreateMissionDto: ReqCreateMissionDto): ResponseEntity<Response<ResMissionDto>> {
        val mission = missionService.create(reqCreateMissionDto)
        val response = Response(200, "", "", mission)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}