package com.hobby.tracker.services

import com.hobby.tracker.clients.RawgClient
import com.hobby.tracker.models.RawgResponse

class RawgService(
    private val rawgClient: RawgClient,
) {
    suspend fun getAllGames(): RawgResponse {
        return rawgClient.getAllGames()
    }
}