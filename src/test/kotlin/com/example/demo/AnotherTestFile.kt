package com.example.demo

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIT {
    @Autowired
    private val template: TestRestTemplate? = null

    @Throws(Exception::class)
    @Test
    fun hello() {
        val response = template!!.getForEntity("/", String::class.java)
        Assertions.assertThat(response.body).isEqualTo("Hello there.")
    }
}