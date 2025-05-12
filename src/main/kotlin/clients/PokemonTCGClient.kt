package com.hobby.tracker.clients

import com.hobby.tracker.models.PokemonCard
import com.hobby.tracker.models.Series
import com.hobby.tracker.models.SeriesBrief
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
    suspend fun searchPokemonTCG(id: String): PokemonCard {
        val response = baseClient("GET", "en", "card", id, endpoint = config.pokemonEndpoint)
        val card = Json.decodeFromString<PokemonCard>(
            response.bodyAsText()
        )
        return card
    }
    suspend fun searchPokemonTCGSets(): ArrayList<Set> {
        val response = baseClient("GET", "en", "sets", endpoint = config.pokemonEndpoint)

        val sets = Json.decodeFromString<ArrayList<Set>>(
            response.bodyAsText()
        )
        return sets
    }
    suspend fun retrievePokemonTCGSet(setName: String): Set {
        val response = baseClient("GET", "en", "set", setName, endpoint = config.pokemonEndpoint)

        val sets = Json.decodeFromString<Set>(
            response.bodyAsText()
        )
        return sets
    }
    suspend fun searchPokemonTCGSeries(): ArrayList<Series> {
        val response = baseClient("GET", "en", "series", endpoint = config.pokemonEndpoint)

        val sets = Json.decodeFromString<ArrayList<Series>>(
            response.bodyAsText()
        )
        return sets
    }
    suspend fun retrievePokemonTCGSeries(seriesName: String): SeriesBrief {
        val response = baseClient("GET", "en", "series", seriesName, endpoint = config.pokemonEndpoint)

        val sets = Json.decodeFromString<SeriesBrief>(
            response.bodyAsText()
        )
        return sets
    }
    suspend fun retrievePokemonTCGRarities(): ArrayList<String> {
        val response = baseClient("GET", "en", "rarities", endpoint = config.pokemonEndpoint)

        val rarities = Json.decodeFromString<ArrayList<String>>(
            response.bodyAsText()
        )
        return rarities
    }
}