package com.hobby.tracker.domain.rawg.routes

import com.hobby.tracker.domain.rawg.services.RawgService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.registerRawgRoutes(service: RawgService) {
    routing {
        getAllGames(service)
        getGameByName(service)
    }
}

private fun Route.getAllGames(service: RawgService) {
    get("/games") {
        call.respondNullable(service.getAllGames(null))
    }

    get("/games/{page_size}") {
        val pageSize: String? = call.parameters["page_size"]
        if (pageSize != null) {
            call.respond(service.getAllGames(pageSize))
        } else call.respond(service.getAllGames(null))
    }
}

private fun Route.getGameByName(service: RawgService) {
    get("/games/{name}") {
        val name = call.parameters["name"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
        val gameList = service.getGameByName(name)
        call.respondNullable(gameList)
    }
}