package com.example.kotlin_blog.domain.post

import com.linecorp.kotlinjdsl.query.spec.ExpressionOrderSpec
import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.support.PageableExecutionUtils

interface PostRepository : JpaRepository<Post, Long> {

}

interface PostCustomRepository {

    fun findPosts(pageable: Pageable): Page<Post>
}

class PostCustomRepositoryImpl (
    private val queryFactory: SpringDataQueryFactory
) : PostCustomRepository {
    override fun findPosts (pageable: Pageable) : Page<Post> {
        val postPage = queryFactory.listQuery<Post> {
            select(entity(Post::class))
            from(entity(Post::class))
            limit(pageable.pageSize)
            offset(pageable.offset.toInt())
            orderBy(ExpressionOrderSpec(column(Post::id), true))
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