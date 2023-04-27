package com.example.kotlin_blog.domain.post

import com.example.kotlin_blog.domain.member.Member
import com.example.kotlin_blog.domain.member.MemberRes

data class PostSaveReq(
    val title:String,
    val content:String,
    val memberId: Long
)

data class PostRes(
    val id:Long,
    val title:String,
    val content: String,
    val member: MemberRes
)

fun PostSaveReq.toEntity(): Post = Post(
    title = this.title,
    content = this.content,
    member = Member.createFakeMember(memberId)
)