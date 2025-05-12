package com.hobby.tracker.services

import io.ktor.server.config.*

class ConfigService(config: ApplicationConfig) {
    val pokemonEndpoint: String = config.property("ktor.api.pokemonTCG.url.endpoint").getString()
    val rawgEndpoint: String = config.property("ktor.api.rawg.url.endpoint").getString()
}