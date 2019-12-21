package com.mahsup.ahoubsu.file.service

import com.mahsup.ahoubsu.mission.domain.Mission
import com.mahsup.ahoubsu.mission.domain.MissionRepository
import com.mahsup.ahoubsu.mission.dto.ReqCreateMissionDto
import com.mahsup.ahoubsu.mission.dto.ResMissionDto
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.stream.Collectors

@Service
class FileService(val missionRepository: MissionRepository) {
    fun fetch(): MutableList<ResMissionDto>? {
        //TODO :: missions에 저장날자가 오늘과 같은지 chec
        // 같다면 missions 리턴 다를경우 mission 을 오늘 날자에 생성

        val missions = missionRepository.fetch().stream().map { mission -> ResMissionDto(mission.id, mission.title, mission.isContent, mission.isContent) }.collect(Collectors.toList())
        //TODO :: missions
        println(LocalDate.now())

        return missions
    }

    fun create(reqCreateMissionDto: ReqCreateMissionDto): ResMissionDto {
        val mission = Mission(reqCreateMissionDto.title, reqCreateMissionDto.isContent, reqCreateMissionDto.isImage)
        missionRepository.save(mission)
        return ResMissionDto(mission.id, mission.title, mission.isContent, mission.isContent)
    }
}
