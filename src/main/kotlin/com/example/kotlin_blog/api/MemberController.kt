package com.example.kotlin_blog.api

import com.example.kotlin_blog.domain.member.MemberSaveReq
import com.example.kotlin_blog.service.MemberService
import com.example.kotlin_blog.util.CommonRes
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/api")
@RestController
class MemberController (
    private val memberService: MemberService
) {

    @GetMapping("/find")
    fun findAll(@PageableDefault(size = 10) pageable: Pageable): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find All Members Complete", memberService.findAll(pageable))

    @GetMapping("/find/{id}")
    fun findMember(@PathVariable id:Long): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Find Member Complete", memberService.findById(id))

    @DeleteMapping("/delete/{id}")
    fun deleteMember(@PathVariable id: Long): CommonRes<*> =
        CommonRes(HttpStatus.OK, "Delete Member Complete", memberService.deleteMemberById(id))

    @PostMapping("/save")
    fun saveMember(@RequestBody dto:MemberSaveReq): CommonRes<Any> =
        CommonRes(HttpStatus.OK, "Save Member Complete", memberService.saveMember(dto))

}