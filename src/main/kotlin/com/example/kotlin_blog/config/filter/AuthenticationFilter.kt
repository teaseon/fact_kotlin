package com.example.kotlin_blog.config.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import mu.KotlinLogging
import java.lang.RuntimeException

class AuthenticationFilter : Filter {

    val log = KotlinLogging.logger {  }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        val servletRequest = request as HttpServletRequest
        val principal = servletRequest.session.getAttribute("principal")

        if(principal == null){
            throw RuntimeException("principal not found")
        } else chain?.doFilter(request, response)
    }


}