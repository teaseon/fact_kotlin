package com.example.kotlin_blog.api

import com.example.kotlin_blog.service.PostService
import com.example.kotlin_blog.util.CommonRes
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController (
    private val postService: PostService
) {

    @GetMapping("/posts")
    fun findAll() : CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find All Posts Complete", postService.findAll())
}