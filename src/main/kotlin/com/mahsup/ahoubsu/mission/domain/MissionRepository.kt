package com.mahsup.ahoubsu.mission.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MissionRepository : JpaRepository<Mission, Long> {
    @Query(nativeQuery = true, value = "select * from chocopie.missions ORDER BY RAND() LIMIT 3")
    fun fetch(): List<Mission>
}