package com.hobby.tracker.services

import com.hobby.tracker.clients.PokemonTCGClient
import com.hobby.tracker.models.PokemonCard
import com.hobby.tracker.models.Series
import com.hobby.tracker.models.SeriesBrief
import com.hobby.tracker.models.Set

class PokemonTCGService(private val client: PokemonTCGClient) {
    suspend fun getPokemonCardById(id: String): PokemonCard {
        return client.searchPokemonTCG(id)
    }

    suspend fun getAllPokemonTCGSeries(): ArrayList<Series> {
        return client.searchPokemonTCGSeries()
    }

    suspend fun getPokemonTCGSeries(seriesName: String): Series {
        return client.retrievePokemonTCGSeries(seriesName)
    }

    suspend fun getPokemonSets(): List<Set> {
        return client.searchPokemonTCGSets()
    }

    suspend fun getPokemonSet(setName: String): Set {
        return client.retrievePokemonTCGSet(setName)
    }

    suspend fun getPokemonRarities(): List<String> {
        return client.retrievePokemonTCGRarities()
    }
}