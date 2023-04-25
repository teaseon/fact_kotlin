package com.example.fact_api_refactor_kotlin.domain.comment

import com.example.fact_api_refactor_kotlin.domain.AuditingEntity
import com.example.fact_api_refactor_kotlin.domain.member.Member
import com.example.fact_api_refactor_kotlin.domain.post.Post
import jakarta.persistence.*


@Entity
@Table(name = "Comment")
class Comment (
    content:String,
    post: Post
) : AuditingEntity() {


    @Column(name = "content")
    var content:String = content
        protected set

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Post::class)
    var post: Post = post
        protected set

}