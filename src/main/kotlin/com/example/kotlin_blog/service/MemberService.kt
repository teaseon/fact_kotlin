package com.example.kotlin_blog.service

import com.example.kotlin_blog.domain.member.*
import com.example.kotlin_blog.exception.MemberNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = true)
    fun findAll(pageable: Pageable): Page<MemberRes> = memberRepository.findMembers(pageable).map { it.toDto() }

    @Transactional
    fun findById(id:Long): MemberRes = memberRepository
        .findById(id)
        .orElseThrow{
            throw MemberNotFoundException(id)
        }.toDto()


    @Transactional
    fun deleteMemberById(id: Long) = memberRepository.deleteById(id)


    @Transactional
    fun saveMember(dto: MemberSaveReq) = memberRepository.save(dto.toEntity())


//    @Transactional
//    fun modifyMember(){
//        memberRepository.
//    }


}