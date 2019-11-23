package com.mahsup.ahoubsu.model

data class Response<T>(val status: Int, val error: String? = null, val message: String?, val data: T?){
    constructor(status: Int, error: String? = null, data: T?) :this(status, error, null, data)
    constructor(data: T?) :this(200, null, null, data)
}