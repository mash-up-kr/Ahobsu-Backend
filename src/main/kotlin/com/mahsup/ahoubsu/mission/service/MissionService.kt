package com.mahsup.ahoubsu.mission.service

import com.mahsup.ahoubsu.mission.domain.Mission
import com.mahsup.ahoubsu.mission.domain.MissionRepository
import com.mahsup.ahoubsu.mission.dto.ReqCreateMissionDto
import com.mahsup.ahoubsu.mission.dto.ResMissionDto
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class MissionService(val missionRepository: MissionRepository) {
    fun fetch(): MutableList<ResMissionDto>? {
        val missions = missionRepository.fetch().stream().map { mission -> ResMissionDto(mission) }.collect(Collectors.toList())
        return missions
    }
    fun create(reqCreateMissionDto: ReqCreateMissionDto): ResMissionDto {
        val mission = Mission(reqCreateMissionDto.title, reqCreateMissionDto.isContent, reqCreateMissionDto.isImage)
        missionRepository.save((mission))
        return ResMissionDto(mission)
    }
}
