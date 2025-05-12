package com.hobby.tracker.models

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
data class UserWishList(
    val wishlist: List<PokemonCard>? = null,
)