package com.example.kotlin_blog.service

import com.example.kotlin_blog.domain.member.MemberRes
import com.example.kotlin_blog.domain.member.toDto
import com.example.kotlin_blog.domain.post.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService (
    private val postRepository: PostRepository
) {

    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<PostRes> = postRepository.findPosts(pageable).map { it.toDto() }

    @Transactional
    fun findById(id: Long) = postRepository.findById(id)

    @Transactional
    fun deletePostById(id:Long) = postRepository.deleteById(id)

    @Transactional
    fun savePost(dto:PostSaveReq) = postRepository.save(dto.toEntity())

//    @Transactional
//    fun modifyPost(){
//
//    }

}