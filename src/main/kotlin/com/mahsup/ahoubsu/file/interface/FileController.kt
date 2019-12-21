package com.mahsup.ahoubsu.file.`interface`

import com.mahsup.ahoubsu.file.service.FileService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/files")
class FileController(val fileservice: FileService) {

    // throws IOException
    @PostMapping
    fun uploadFile(@RequestParam("file") file: MultipartFile): MultipartFile {
        println(file)
        println("12344567890-")
        return file
    }

}