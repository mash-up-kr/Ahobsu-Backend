package com.mahsup.ahoubsu.model

data class Response<T>(val status: Int, val error: String? = null, val message: String?, val data: T?)