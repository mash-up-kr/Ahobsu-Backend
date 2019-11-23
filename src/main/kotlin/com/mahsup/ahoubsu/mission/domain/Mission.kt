package com.mahsup.ahoubsu.mission.domain

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "missions")
data class Mission(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
                   var title: String,
                   var isContent: Boolean,
                   var isImage: Boolean) {
    constructor(title: String, isContent: Boolean, isImage: Boolean) :
            this(null, title, isContent, isImage)
}