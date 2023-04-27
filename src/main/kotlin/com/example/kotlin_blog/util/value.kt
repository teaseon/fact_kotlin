package com.example.kotlin_blog.util

data class CommonRes<T>(
    val resultCode:T,
    val resultMsg:String,
    val data:T
)