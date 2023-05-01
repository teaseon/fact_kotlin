package com.example.kotlin_blog.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
    val code : String,
    val message : String
) {
    INVALID_INPUT_VALUE("CD01", "Invalid Input Value"),
    ENTITY_NOT_FOUND("CD02", "Entity Not Found")


}