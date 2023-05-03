package com.example.kotlin_blog.config.aop

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jsonMapper
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Component
@Aspect
class LoggerAspect {

    val log = KotlinLogging.logger{  }

    @Pointcut("execution(* com.example.kotlin_blog.api.*Controller.*(..))")
    private fun controllerCut() = Unit

    @Before("controllerCut()")
    fun controllerLoggerAdvice(joinPoint: JoinPoint){

        val typeName = joinPoint.signature.declaringType
        val methodName = joinPoint.signature.name
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request

        log.info { """
            request url : ${request.servletPath}
            type : $typeName
            method : $methodName
        """.trimIndent() }

    }

    @AfterReturning(pointcut = "controllerCut()", returning = "result")
    fun controllerLogAfter(joinPoint: JoinPoint, result: Any){

        log.info {
            """
            ${joinPoint.signature.name} 
            method return value : ${result}
            """.trimIndent()
        }
    }

}