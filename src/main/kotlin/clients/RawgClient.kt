package com.hobby.tracker.clients

import com.hobby.tracker.models.RawgResponse
import com.hobby.tracker.services.ConfigService
import io.ktor.client.*
import io.ktor.client.statement.*
import io.ktor.util.logging.*
import kotlinx.serialization.json.Json

class RawgClient(
    private val config: ConfigService,
    httpClient: HttpClient,
    log: Logger
): BaseClient(httpClient) {
    private val rawgLogger = log

    suspend fun getGameByName(searchParameter: String): RawgResponse {
        val setQueryParams = mapOf("key" to config.rawgAPIKey, "search" to searchParameter, "page_size" to "5")
        val response = baseClient("GET", "api", "games", endpoint = config.rawgEndpoint, queryParams = setQueryParams)
        rawgLogger.info("getGameByName(\"$searchParameter\") -- $response")
        rawgLogger.info(response.bodyAsText())

        val games = Json.decodeFromString<RawgResponse>(
            response.bodyAsText()
        )
        return games
    }
}