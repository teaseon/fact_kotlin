package com.example.kotlin_blog.api

import com.example.kotlin_blog.domain.member.Member
import com.example.kotlin_blog.service.MemberService
import com.example.kotlin_blog.util.CommonRes
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService
) {

    @GetMapping("/members")
    fun findAll(): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find All Members Complete", memberService.findAll())

}