package com.example.kotlin_blog.config.filter

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FilterConfig {

    @Bean
    fun registAuthenticationFilter(): FilterRegistrationBean<AuthenticationFilter> {
        val bean = FilterRegistrationBean(AuthenticationFilter())

        bean.addUrlPatterns("/api/*")
        bean.order = 0
        return bean
    }

}