package com.hobby.tracker.domain.rawg.services

import com.hobby.tracker.domain.rawg.clients.RawgClient
import com.hobby.tracker.domain.rawg.model.RawgResponse
import com.hobby.tracker.domain.rawg.repository.IRawgRepository

class RawgService(
    private val rawgRepo: IRawgRepository,
) {

    suspend fun getAllGames(pageSize: String?): String {
        if (pageSize != null) {
            return rawgRepo.getAllGames(pageSize)
        }
        return rawgRepo.getAllGames()
    }

    suspend fun getGameByName(searchParameter: String): RawgResponse {
        return rawgRepo.getGameByName(searchParameter)
    }
}