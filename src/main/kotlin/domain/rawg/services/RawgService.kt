package com.hobby.tracker.domain.rawg.services

import com.hobby.tracker.domain.rawg.clients.RawgClient
import com.hobby.tracker.domain.rawg.model.RawgResponse

class RawgService(
    private val rawgClient: RawgClient,
) {

    suspend fun getAllGames(pageSize: String? = "5"): RawgResponse {
        return rawgClient.getAllGames(pageSize)
    }

    suspend fun getGameByName(searchParameter: String): RawgResponse {
        return rawgClient.getGameByName(searchParameter)
    }
}