//package net.fonix232.birdie
//
//import io.ktor.application.*
//import io.ktor.response.*
//import io.ktor.request.*
//import io.ktor.routing.*
//import io.ktor.http.*
//import io.ktor.html.*
//import kotlinx.html.*
//import kotlinx.css.*
//import io.ktor.content.*
//import io.ktor.http.content.*
//import io.ktor.locations.*
//import io.ktor.sessions.*
//import io.ktor.features.*
//import org.slf4j.event.*
//import io.ktor.util.date.*
//import io.ktor.server.engine.*
//import io.ktor.websocket.*
//import io.ktor.http.cio.websocket.*
//import java.time.*
//import io.ktor.auth.*
//import io.ktor.gson.*
//import kotlin.test.*
//import io.ktor.server.testing.*
//
//class ApplicationTest {
//    @Test
//    fun testRoot() {
//        withTestApplication({ module(testing = true) }) {
//            handleRequest(HttpMethod.Get, "/").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals("HELLO WORLD!", response.content)
//            }
//        }
//    }
//}
