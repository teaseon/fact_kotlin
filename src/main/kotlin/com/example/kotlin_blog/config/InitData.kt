package com.example.kotlin_blog.config

import com.example.kotlin_blog.domain.member.*
import com.example.kotlin_blog.domain.post.Post
import com.example.kotlin_blog.domain.post.PostRepository
import com.example.kotlin_blog.domain.post.PostSaveReq
import com.example.kotlin_blog.domain.post.toEntity
import io.github.serpro69.kfaker.faker
import mu.KLogger
import mu.KotlinLogging
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitData (
    private val memberRepository: MemberRepository,
    private val postRepository: PostRepository,

) {

    val faker = faker { }

    private val log = KotlinLogging.logger {}

    @EventListener(ApplicationReadyEvent::class)
    private fun init(){

//
//        val members = mutableListOf<Member>()
//        val posts = mutableListOf<Post>()
//        for(i in 1..100){
//            val member = generateMember()
//            members.add(member)
//
//            val post = generatePost()
//            posts.add(post)
//
//        }
//        memberRepository.saveAll(members)
//        postRepository.saveAll(posts)
    }

    private fun generateMember(): Member = MemberSaveReq(
        email = faker.internet.safeEmail(),
        password = "1234",
        role = Role.USER
    ).toEntity()

    private fun generatePost(): Post = PostSaveReq(
        title = faker.theExpanse.ships(),
        content = faker.quote.robin(),
        memberId = 1
    ).toEntity()



}