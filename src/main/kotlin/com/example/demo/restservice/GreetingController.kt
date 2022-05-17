package com.example.demo.restservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.concurrent.atomic.AtomicLong

//@RestController()
class GreetingController {

    companion object {
        private const val template = "Hello, %s!"
        private val counter = AtomicLong()
    }

    @GetMapping("/")
    fun index(): String {
        return "Hello there."
    }

    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }
}