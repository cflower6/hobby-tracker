package com.hobby.tracker.domain.pokemon.repository

import com.hobby.tracker.domain.pokemon.clients.PokemonTCGClient
import com.hobby.tracker.domain.pokemon.model.PokemonCard
import com.hobby.tracker.domain.pokemon.model.Series
import com.hobby.tracker.domain.pokemon.model.Set
import io.ktor.util.logging.Logger

class PokemonTCGRepository(
    private val tcgClient: PokemonTCGClient,
    log: Logger
): IPokemonTCGRepository {
    private val pokemonRepoLogger = log

    override suspend fun getPokemonCardById(id: String): PokemonCard? {
        return tcgClient.searchPokemonTCG(id)
    }

    override suspend fun getAllPokemonTCGSeries(): ArrayList<Series>? {
        return tcgClient.searchPokemonTCGSeries()
    }

    override suspend fun getPokemonTCGSeries(seriesName: String): Series? {
        return tcgClient.retrievePokemonTCGSeries(seriesName)
    }

    override suspend fun getPokemonSets(): List<Set> {
        return tcgClient.searchPokemonTCGSets()
    }

    override suspend fun getPokemonSet(setName: String): Set {
        return tcgClient.retrievePokemonTCGSet(setName)
    }

    override suspend fun getPokemonRarities(): List<String> {
        return tcgClient.retrievePokemonTCGRarities()
    }
}