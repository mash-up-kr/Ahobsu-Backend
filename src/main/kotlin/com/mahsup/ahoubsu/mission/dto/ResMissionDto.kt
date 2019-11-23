package com.mahsup.ahoubsu.mission.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.mahsup.ahoubsu.mission.domain.Mission

data class ResMissionDto(
        val id: Long,
        val title: String,
        @get:JsonProperty("isContent")
        val isContent: Boolean,
        @get:JsonProperty("isImage")
        val isImage: Boolean
) {
    constructor(mission: Mission) :
            this(mission.id!!, mission.title, mission.isContent, mission.isImage)
}