package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.logging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.cio.*
import io.ktor.utils.io.*
import kotlinx.html.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
data class User(
    @SerialName("name")
    val name:String,
    @SerialName("age")
    val age:Int
)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hi from server")
        }
        post("/login") {
            val login = call.receiveText()
            println(login)
            call.respond(User("Name", age = 1))
        }
    }
}
