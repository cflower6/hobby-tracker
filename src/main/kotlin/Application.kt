package com.hobby.tracker

import com.hobby.tracker.clients.ApiClient
import com.hobby.tracker.domain.pokemon.clients.PokemonTCGClient
import com.hobby.tracker.domain.pokemon.repository.PokemonTCGRepository
import com.hobby.tracker.domain.rawg.clients.RawgClient
import com.hobby.tracker.domain.user.repository.FakeUserRepository
import com.hobby.tracker.domain.pokemon.routes.registerPokemonRoutes
import com.hobby.tracker.domain.rawg.routes.registerRawgRoutes
import com.hobby.tracker.domain.user.routes.userRoutes
import com.hobby.tracker.util.ConfigService
import com.hobby.tracker.domain.pokemon.services.PokemonTCGService
import com.hobby.tracker.domain.rawg.repository.RawgRepository
import com.hobby.tracker.domain.rawg.services.RawgService
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
            explicitNulls = true
        })
    }
    val configService = ConfigService(environment.config)
    val httpClient = ApiClient().createClient(Apache5.create(), "Apache5")
    val pokemonClient = PokemonTCGClient(configService, httpClient, log)
    val pokemonTCGRepository = PokemonTCGRepository(pokemonClient, log)
    val pokemonTCGService = PokemonTCGService(pokemonTCGRepository)
    val rawgClient = RawgClient(configService, httpClient, log)
    val rawgRepository = RawgRepository(rawgClient, log)
    val rawgService = RawgService(rawgRepository)
    val userRepository = FakeUserRepository(log)


    registerPokemonRoutes(pokemonTCGService)
    registerRawgRoutes(rawgService)
    userRoutes(userRepository)
    configureRouting()
}
