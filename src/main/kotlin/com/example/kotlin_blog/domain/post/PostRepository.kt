package com.example.kotlin_blog.domain.post

import com.example.kotlin_blog.domain.member.Member
import com.linecorp.kotlinjdsl.query.spec.ExpressionOrderSpec
import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.querydsl.from.fetch
import com.linecorp.kotlinjdsl.querydsl.from.join
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import jakarta.persistence.criteria.JoinType
//import com.querydsl.jpa.impl.JPAQueryFactory
//import jakarta.persistence.criteria.JoinType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.transaction.annotation.Transactional

interface PostRepository : JpaRepository<Post, Long>, PostCustomRepository {

}

interface PostCustomRepository {

    fun findPosts(pageable: Pageable): Page<Post>
}

    @Transactional
class PostCustomRepositoryImpl (
    private val queryFactory: SpringDataQueryFactory
//    private val queryFactory : JPAQueryFactory
) : PostCustomRepository {

    override fun findPosts (pageable: Pageable) : Page<Post> {

////        queryDsl
//        val postPage = queryFactory
//            .selectFrom(QPost)


//        jdsl
        val postPage = queryFactory.listQuery<Post> {
            select(entity(Post::class))
            from(entity(Post::class))
            fetch(Post::member)
            limit(pageable.pageSize)
            offset(pageable.offset.toInt())
            orderBy(ExpressionOrderSpec(column(Post::id), false))
        }

        val count = queryFactory.listQuery<Post> {
            select(entity(Post::class))
            from(entity(Post::class))
        }

        return PageableExecutionUtils.getPage(postPage, pageable){
            count.size.toLong()
        }
    }
}