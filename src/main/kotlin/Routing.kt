package com.hobby.tracker

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    val status: String
)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(Status("OK"))
        }
        get("/status") {
            call.respond(Status("OK"))
        }
    }
}
