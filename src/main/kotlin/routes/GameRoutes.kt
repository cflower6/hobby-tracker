package com.hobby.tracker.routes

import com.hobby.tracker.services.PokemonTCGService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.registerRawgRoutes(service: PokemonTCGService) {
    routing {
        getGameByName(service)
    }
}

private fun Route.getGameByName(service: PokemonTCGService) {
    get("/games/{name}") {
        val name = call.parameters["name"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        call.respondText("FOUND")
    }
}