package com.example.kotlin_blog.service

import com.example.kotlin_blog.domain.member.Member
import com.example.kotlin_blog.domain.member.MemberRepository
import com.example.kotlin_blog.domain.member.MemberRes
import com.example.kotlin_blog.domain.member.toDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = true)
    fun findAll(): List<MemberRes> =
        memberRepository.findMembers().map {
            it.toDto()
        }


}