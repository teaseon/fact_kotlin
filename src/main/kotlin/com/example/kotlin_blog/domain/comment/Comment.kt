package com.example.kotlin_blog.domain.comment

import com.example.kotlin_blog.domain.AuditingEntity
import com.example.kotlin_blog.domain.post.Post
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