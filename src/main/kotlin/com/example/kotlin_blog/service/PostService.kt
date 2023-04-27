package com.example.kotlin_blog.service

import com.example.kotlin_blog.domain.member.MemberRes
import com.example.kotlin_blog.domain.member.toDto
import com.example.kotlin_blog.domain.post.Post
import com.example.kotlin_blog.domain.post.PostRepository
import com.example.kotlin_blog.domain.post.PostRes
import com.example.kotlin_blog.domain.post.toDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService (
    private val postRepository: PostRepository
) {

//    fun findPosts() :

    @Transactional(readOnly = true)
    fun findAll(): List<PostRes> = postRepository.findAll().map { it.toDto() }
}