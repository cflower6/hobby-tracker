package com.hobby.tracker.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@OptIn(ExperimentalSerializationApi::class)
@JsonIgnoreUnknownKeys
@Serializable
data class PokemonCard(
    val category: String? = null,
    val id: String? = null,
    val illustrator: String? = null,
    val image: String? = null,
    val localId: String? = null,
    val name: String? = null,
    val rarity: String? = null,
    val set: Set? = null,
    val variants: Variant? = null,
    val dexId: ArrayList<Int>? = null,
    val hp: Int? = null,
    val types: ArrayList<String>? = null,
    val evolveFrom: String? = null,
    val description: String? = null,
    val stage: String? = null,
    val attacks: ArrayList<Attack>? = null,
    val weaknesses: ArrayList<Weakness>? = null,
    val retreat: Int? = null,
    val legal: Legal? = null,
    val updated: String? = null,
)

@Serializable
data class Set(
    val cardCount: CardCount,
    val id: String,
    val logo: String? = null,
    val name: String? = null,
    val symbol: String? = null
)

@Serializable
data class SeriesBrief(
    val id: String,
    val name: String,
)

@Serializable
data class Series(
    val id: String,
    val logo: String? = null,
    val name: String,
    val sets: ArrayList<Set>
)

@Serializable
data class CardCount (
    val official: Int,
    val total: Int
)

@Serializable
data class Legal(
    val standard: Boolean,
    val expanded: Boolean
)

@Serializable
data class Weakness(
    val type: String,
    val value: String
)

@Serializable
data class Attack(
    val cost: ArrayList<String>,
    val name: String,
    val effect: String,
    val damage: Int? = null
)

@Serializable
data class Variant(
    val firstEdition: Boolean,
    val holo: Boolean,
    val normal: Boolean,
    val reverse: Boolean,
    val wPromo: Boolean,
)