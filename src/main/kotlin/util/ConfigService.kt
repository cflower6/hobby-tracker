package com.hobby.tracker.util

import io.ktor.server.config.ApplicationConfig

class ConfigService(config: ApplicationConfig) {
    val pokemonEndpoint: String = config.property("ktor.api.pokemonTCG.url.endpoint").getString()
    val rawgEndpoint: String = config.property("ktor.api.rawg.url.endpoint").getString()
    val rawgAPIKey: String = config.property("ktor.api.rawg.authentication.key").getString()
}