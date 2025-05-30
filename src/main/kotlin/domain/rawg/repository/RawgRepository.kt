package com.hobby.tracker.domain.rawg.repository

import com.hobby.tracker.domain.rawg.clients.RawgClient
import com.hobby.tracker.domain.rawg.model.RawgResponse
import io.ktor.util.logging.*

class RawgRepository(
    private val rawgClient: RawgClient,
    log: Logger
): IRawgRepository {
    override suspend fun getAllGames(pageSize: String?): String {
        if (pageSize == null || pageSize == "") {
            return rawgClient.getAllGames()
        }
        return rawgClient.getAllGames(pageSize)
    }

    override suspend fun getGameByName(searchParameter: String): RawgResponse {
        return rawgClient.getGameByName(searchParameter)
    }

}