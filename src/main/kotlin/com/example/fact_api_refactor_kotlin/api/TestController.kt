package com.example.fact_api_refactor_kotlin.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController() {


    @GetMapping("/health")
    fun healthTest():String = "server OK"

}