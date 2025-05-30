package com.hobby.tracker.domain.user.models

import com.hobby.tracker.domain.pokemon.model.PokemonCard
import kotlinx.serialization.Serializable


@Serializable
data class User(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val avatarUrl: String? = null,
    val bio: String? = null,
    val collections: List<PokemonCard>? = null,
    val username: String? = null,
)

@Serializable
data class UserSearchCriteria(
    val email: String,
    val password: String,
)

@Serializable
data class UserPokemonList(
    val ownedPokemonList: List<PokemonCard>? = null,
)

@Serializable
data class UserGameList(
    val ownedGameList: List<PokemonCard>? = null,
)