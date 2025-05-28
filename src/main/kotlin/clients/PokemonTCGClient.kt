package com.hobby.tracker.clients

import com.hobby.tracker.models.PokemonCard
import com.hobby.tracker.models.Series
import com.hobby.tracker.models.Set
import com.hobby.tracker.services.ConfigService
import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

class PokemonTCGClient(
    private val config: ConfigService,
    httpClient: HttpClient,
    log: Logger
): BaseClient(httpClient) {
    private val pokemonTCGLogger = log

    suspend fun searchPokemonTCG(id: String): PokemonCard {
        val response = baseClient("GET", "en", "card", id, endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val card = Json.decodeFromString<PokemonCard>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("PokemonCard: $card")
        return card
    }

    suspend fun searchPokemonTCGSets(): ArrayList<Set> {
        val response = baseClient("GET", "en", "sets", endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val sets = Json.decodeFromString<ArrayList<Set>>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("Sets: $sets")
        return sets
    }

    suspend fun retrievePokemonTCGSet(setName: String): Set {
        val response = baseClient("GET", "en", "sets", setName, endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val sets = Json.decodeFromString<Set>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("PokemonCard: $sets")
        return sets
    }

    suspend fun searchPokemonTCGSeries(): ArrayList<Series> {
        val response = baseClient("GET", "en", "series", endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val sets = Json.decodeFromString<ArrayList<Series>>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("Series: $sets")
        return sets
    }

    suspend fun retrievePokemonTCGSeries(seriesName: String): Series {
        val response = baseClient("GET", "en", "series", seriesName, endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val sets = Json.decodeFromString<Series>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("Series: $sets")
        return sets
    }

    suspend fun retrievePokemonTCGRarities(): ArrayList<String> {
        val response = baseClient("GET", "en", "rarities", endpoint = config.pokemonEndpoint)
        pokemonTCGLogger.info("Response: $response")
        val rarities = Json.decodeFromString<ArrayList<String>>(
            response.bodyAsText()
        )
        pokemonTCGLogger.info("Rarities: $rarities")
        return rarities
    }
}