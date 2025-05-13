package com.hobby.tracker.clients

import com.hobby.tracker.models.RawgResponse
import com.hobby.tracker.services.ConfigService
import io.ktor.client.*
import io.ktor.util.logging.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class RawgClient(
    private val config: ConfigService,
    httpClient: HttpClient,
    log: Logger
): BaseClient(httpClient) {
    private val rawgLogger = log

    suspend fun getAllGames(): RawgResponse {

        val response = baseClient("GET", "api", "games", endpoint = config.rawgEndpoint)

        rawgLogger.info("getAllGames() -- $response")

        val games = Json.decodeFromString<RawgResponse>(
            response.bodyAsText()
        )
        return games
    }
}