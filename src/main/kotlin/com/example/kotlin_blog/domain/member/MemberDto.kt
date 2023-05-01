package com.example.kotlin_blog.domain.member

import jakarta.validation.constraints.NotNull

data class MemberSaveReq(
    @field:NotNull(message = "Require email")
    val email:String,
    val password:String,
    val role:Role
)

data class MemberRes(
    val id:Long,
    val email:String,
    val password:String,
    val role:Role
)
fun MemberSaveReq.toEntity(): Member {
    return Member(
        email = this.email?: "",
        password = this.password?: "",
        role = this.role?: Role.USER
    )
}

