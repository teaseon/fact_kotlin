package com.example.kotlin_blog.domain.post

import com.example.kotlin_blog.domain.member.Member
import com.example.kotlin_blog.domain.member.MemberRes
import jakarta.validation.constraints.NotNull

data class PostSaveReq(
    @field:NotNull(message = "Require title")
    val title:String,
    val content:String,

    @field:NotNull(message = "Require MemberId")
    val memberId: Long
)

data class PostRes(
    val id:Long,
    val title:String,
    val content: String,
    val member: MemberRes
)

fun PostSaveReq.toEntity(): Post = Post(
    title = this.title?: "",
    content = this.content?: "",
    member = Member.createFakeMember(memberId!!)
)