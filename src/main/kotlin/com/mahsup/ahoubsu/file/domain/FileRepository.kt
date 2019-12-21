package com.mahsup.ahoubsu.file.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface FileRepository : JpaRepository<File, Long> {
    @Query(nativeQuery = true, value = "select * from chocopie.missions ORDER BY RAND() LIMIT 3")
    fun fetch(): List<File>
}