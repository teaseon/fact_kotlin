package com.example.kotlin_blog.config

import com.example.kotlin_blog.domain.member.*
import io.github.serpro69.kfaker.faker
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

@Configuration
class InitData (
    private val memberRepository: MemberRepository
) {

    val faker = faker { }

    @EventListener(ApplicationReadyEvent::class)
    private fun init(){

        val members = mutableListOf<Member>()
        for(i in 1..100){
            val member = generateMember()
            members.add(member)
        }
        memberRepository.saveAll(members)
    }

    private fun generateMember(): Member = MemberSaveReq(
        email = faker.internet.safeEmail(),
        password = "1234",
        role = Role.USER
    ).toEntity()



}