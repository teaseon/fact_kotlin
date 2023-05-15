package com.example.kotlin_blog.domain.member

import com.example.kotlin_blog.domain.AuditingEntity
import com.example.kotlin_blog.domain.post.Post
import jakarta.persistence.*

@Entity
@Table(name = "Member")
class Member (
    email:String,
    password:String,
    role:Role
) :AuditingEntity() {

    @Column(name = "email", nullable = false)
    var email:String = email
        protected set

    @Column(name = "password", nullable = false)
    var password:String = password
        protected set

    @Enumerated(EnumType.STRING)
    var role:Role = role
        protected set

    @OneToMany(mappedBy = "member", targetEntity = Post::class)
    var posts = mutableListOf<Post>()

    override fun toString(): String {
        return "Member(id=$id, email=$email, password=$password, role=$role)"
    }

    companion object {
        fun createFakeMember(memberId:Long): Member {
            val member = Member(" ", " ", Role.USER)
            member.id = memberId
            return member
        }
    }
}

fun Member.toDto() : MemberRes = MemberRes(
    id = this.id!!,
    email = this.email,
    password = this.password,
    role = this.role
)

enum class Role {
    USER, ADMIN
}