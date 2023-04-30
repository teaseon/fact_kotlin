package com.example.kotlin_blog.api

import com.example.kotlin_blog.domain.member.MemberSaveReq
import com.example.kotlin_blog.domain.post.PostSaveReq
import com.example.kotlin_blog.service.PostService
import com.example.kotlin_blog.util.CommonRes
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/post")
@RestController
class PostController (
    private val postService: PostService
) {

    @GetMapping("/find")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable) : CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find All Posts Complete", postService.findAll(pageable))

    @GetMapping("/find/{id}")
    fun findPost(@PathVariable id:Long): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find Post Complete", postService.findById(id))

    @DeleteMapping("/delete/{id}")
    fun deletePost(@PathVariable id: Long): CommonRes<*> =
        CommonRes(HttpStatus.OK, "delete Post Complete", postService.deletePostById(id))


    @PostMapping("/save")
    fun savePost(@RequestBody dto: PostSaveReq): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find Post Complete", postService.savePost(dto))



}