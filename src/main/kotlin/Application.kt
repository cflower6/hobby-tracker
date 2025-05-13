package com.hobby.tracker

import com.hobby.tracker.clients.ApiClient
import com.hobby.tracker.clients.PokemonTCGClient
import com.hobby.tracker.clients.RawgClient
import com.hobby.tracker.repository.FakeUserRepository
import com.hobby.tracker.routes.registerPokemonRoutes
import com.hobby.tracker.routes.registerRawgRoutes
import com.hobby.tracker.routes.userRoutes
import com.hobby.tracker.services.ConfigService
import com.hobby.tracker.services.PokemonTCGService
import com.hobby.tracker.services.RawgService
import io.ktor.client.engine.apache5.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }
    val configService = ConfigService(environment.config)
    val httpClient = ApiClient().createClient(Apache5.create(), "Apache5")
    val pokemonClient = PokemonTCGClient(configService, httpClient, log)
    val pokemonTCGService = PokemonTCGService(pokemonClient)
    val rawgClient = RawgClient(configService, httpClient, log)
    val rawgService = RawgService(rawgClient )
    val userRepository = FakeUserRepository(log)

    registerPokemonRoutes(pokemonTCGService)
    registerRawgRoutes(rawgService)
    userRoutes(userRepository)
    configureRouting()
}
