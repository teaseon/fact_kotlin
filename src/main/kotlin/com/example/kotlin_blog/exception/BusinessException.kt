package com.example.kotlin_blog.exception

sealed class BusinessException : RuntimeException {

    private var errorCode : ErrorCode
        get() = this.errorCode

    constructor(errorCode: ErrorCode):super(errorCode.message){
        this.errorCode = errorCode
    }

    constructor(message: String?, errorCode : ErrorCode):super(message){
        this.errorCode = errorCode
    }


}