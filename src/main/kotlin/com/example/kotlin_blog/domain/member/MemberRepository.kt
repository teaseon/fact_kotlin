package com.example.kotlin_blog.domain.member


import com.linecorp.kotlinjdsl.query.spec.ExpressionOrderSpec
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactoryImpl
import com.linecorp.kotlinjdsl.spring.data.listQuery
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


interface MemberRepository : JpaRepository<Member, Long>, MemberCustomRepository {

}

interface MemberCustomRepository {
    fun findMembers(): List<Member>
}


class MemberCustomRepositoryImpl (
    private val queryFactory: SpringDataQueryFactory
) : MemberCustomRepository {


    override fun findMembers (): List<Member> {
        return queryFactory.listQuery {
            select(entity(Member::class))
            from(entity(Member::class))
            orderBy(ExpressionOrderSpec(column(Member::id), true))
        }
    }

}