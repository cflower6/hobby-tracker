package com.hobby.tracker.domain.rawg.clients

import com.hobby.tracker.clients.BaseClient
import com.hobby.tracker.domain.rawg.model.RawgResponse
import com.hobby.tracker.util.ConfigService
import io.ktor.client.HttpClient
import io.ktor.client.statement.bodyAsText
import io.ktor.util.logging.Logger
import kotlinx.serialization.json.Json

class RawgClient(
    private val config: ConfigService,
    httpClient: HttpClient,
    log: Logger
): BaseClient(httpClient) {
    private val rawgLogger = log

    suspend fun getGameByName(searchParameter: String): RawgResponse {
        val setQueryParams = mapOf("key" to config.rawgAPIKey, "search" to searchParameter, "page_size" to "5")

        val response = baseClient("GET",
            "api", "games",
            endpoint = config.rawgEndpoint,
            queryParams = setQueryParams
        )

        rawgLogger.info("getGameByName(\"$searchParameter\") -- $response")
        rawgLogger.info(response.bodyAsText())

        val games = Json.Default.decodeFromString<RawgResponse>(
            response.bodyAsText()
        )
        return games
    }

    suspend fun getAllGames(pageSize: String? = "5"): RawgResponse {
        val setQueryParams = mapOf("key" to config.rawgAPIKey, "page_size" to "$pageSize")

        val response = baseClient("GET", "api",
            "games", endpoint = config.rawgEndpoint,
            queryParams = setQueryParams
        )

        rawgLogger.info("getAllGames()")

        val games = Json.Default.decodeFromString<RawgResponse>(
            response.bodyAsText()
        )

        return games
    }
}