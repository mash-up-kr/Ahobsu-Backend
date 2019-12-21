package com.mahsup.ahoubsu.file.domain

import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "missions")
data class File(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
                var file: String,
                var date: LocalDate) {
    constructor(file: String, date: LocalDate)
            : this(null, file, date) }