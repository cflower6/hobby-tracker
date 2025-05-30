package com.hobby.tracker.domain.pokemon.repository

import com.hobby.tracker.domain.pokemon.model.PokemonCard
import com.hobby.tracker.domain.pokemon.model.Series
import com.hobby.tracker.domain.pokemon.model.Set

interface IPokemonTCGRepository {
    suspend fun getPokemonCardById(id: String): PokemonCard?

    suspend fun getAllPokemonTCGSeries(): ArrayList<Series>?

    suspend fun getPokemonTCGSeries(seriesName: String): Series?

    suspend fun getPokemonSets(): List<Set>

    suspend fun getPokemonSet(setName: String): Set

    suspend fun getPokemonRarities(): List<String>
}