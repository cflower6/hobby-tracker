package com.hobby.tracker.services

import com.hobby.tracker.clients.RawgClient
import com.hobby.tracker.models.RawgResponse

class RawgService(
    private val rawgClient: RawgClient,
) {
    suspend fun getGameByName(searchParameter: String): RawgResponse {
        return rawgClient.getGameByName(searchParameter)
    }
}