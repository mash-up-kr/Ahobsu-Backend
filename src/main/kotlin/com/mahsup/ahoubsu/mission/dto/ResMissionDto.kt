package com.mahsup.ahoubsu.mission.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ResMissionDto(
        val id: Long?,
        val title: String,
        @get:JsonProperty("isContent")
        val isContent: Boolean,
        @get:JsonProperty("isImage")
        val isImage: Boolean
)