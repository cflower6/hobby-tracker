package com.hobby.tracker.domain.pokemon.routes

import com.hobby.tracker.domain.pokemon.services.PokemonTCGService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.registerPokemonRoutes(service: PokemonTCGService) {
    routing {
        getPokemonByIdRoute(service)
        getAllPokemonTCGSets(service)
        getPokemonRarities(service)
        getPokemonTCGSet(service)
        getAllPokemonTCGSeries(service)
        getPokemonTCGSeries(service)
    }
}

private fun Route.getPokemonByIdRoute(service: PokemonTCGService) {
    get("/pokemon/{id}") {
        val id = call.parameters["id"]
        if (id != null) {
            call.respondNullable(service.getPokemonCardById(id))
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

private fun Route.getAllPokemonTCGSets(service: PokemonTCGService) {
    get("/pokemon/sets") {
        call.respond(service.getPokemonSets() as Any)
    }
}

private fun Route.getPokemonTCGSet(service: PokemonTCGService) {
    get("/pokemon/sets/{setName}") {
        val setName = call.parameters["setName"]
        if (setName != null) {
            call.respondNullable(service.getPokemonSet(setName))
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

private fun Route.getAllPokemonTCGSeries(service: PokemonTCGService) {
    get("/pokemon/series") {
        call.respond(service.getAllPokemonTCGSeries() as Any)
    }
}

private fun Route.getPokemonTCGSeries(service: PokemonTCGService) {
    get("/pokemon/series/{seriesName}") {
        val seriesName = call.parameters["seriesName"]
        if(seriesName != null) {
            call.respondNullable(service.getPokemonTCGSeries(seriesName))
        } else {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

private fun Route.getPokemonRarities(service: PokemonTCGService) {
    get("/pokemon/rarities") {
        call.respond(service.getPokemonRarities() as Any)
    }
}