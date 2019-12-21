package com.mahsup.ahoubsu.mission.`interface`

import com.mahsup.ahoubsu.file.service.FileService
import com.mahsup.ahoubsu.mission.dto.ReqCreateMissionDto
import com.mahsup.ahoubsu.mission.dto.ResMissionDto
import com.mahsup.ahoubsu.model.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/missions")
class MissionController(val missionService: FileService) {
//    @ApiOperation(value = "매칭된 방의 미션 정보 가져오는 API")
//    @ApiResponses(value = [ApiResponse(code = 200, message = "get missions from room")])
    @GetMapping
    fun fetch(): ResponseEntity<Response<MutableList<ResMissionDto>>> {
        val missions = missionService.fetch()
        val response = Response(missions)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
    @PostMapping
    fun create(@RequestBody reqCreateMissionDto: ReqCreateMissionDto): ResponseEntity<Response<ResMissionDto>> {
        val mission = missionService.create(reqCreateMissionDto)
        val response = Response(201, mission)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}