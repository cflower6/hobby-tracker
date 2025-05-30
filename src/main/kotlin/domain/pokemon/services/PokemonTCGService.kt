package com.hobby.tracker.domain.pokemon.services

import com.hobby.tracker.domain.pokemon.model.PokemonCard
import com.hobby.tracker.domain.pokemon.model.Series
import com.hobby.tracker.domain.pokemon.model.Set
import com.hobby.tracker.domain.pokemon.repository.IPokemonTCGRepository

class PokemonTCGService(
    private val pokemonRepo: IPokemonTCGRepository
) {
    suspend fun getPokemonCardById(id: String): PokemonCard? {
        return pokemonRepo.getPokemonCardById(id)
    }

    suspend fun getAllPokemonTCGSeries(): ArrayList<Series>? {
        return pokemonRepo.getAllPokemonTCGSeries()
    }

    suspend fun getPokemonTCGSeries(seriesName: String): Series? {
        return pokemonRepo.getPokemonTCGSeries(seriesName)
    }

    suspend fun getPokemonSets(): List<Set>? {
        return pokemonRepo.getPokemonSets()
    }

    suspend fun getPokemonSet(setName: String): Set? {
        return pokemonRepo.getPokemonSet(setName)
    }

    suspend fun getPokemonRarities(): List<String>? {
        return pokemonRepo.getPokemonRarities()
    }


}