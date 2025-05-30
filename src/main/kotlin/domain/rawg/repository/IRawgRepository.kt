package com.hobby.tracker.domain.rawg.repository

import com.hobby.tracker.domain.rawg.model.RawgResponse

interface IRawgRepository {
    suspend fun getAllGames(pageSize: String? = "5"): String
    suspend fun getGameByName(searchParameter: String): RawgResponse
}