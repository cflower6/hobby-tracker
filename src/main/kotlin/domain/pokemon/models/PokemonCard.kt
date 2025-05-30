package com.hobby.tracker.domain.pokemon.model

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

@OptIn(ExperimentalSerializationApi::class)
@JsonIgnoreUnknownKeys
@Serializable
data class Set(
    val cardCount: CardCount? = null,
    val id: String? = null,
    val logo: String? = null,
    val name: String? = null,
    val symbol: String? = null,
    val cards: List<Card>? = null,
    val legal: Legal? = null,
    val releaseDate: String? = null,
    val serie: SeriesBrief? = null,
    val tcgOnline: String? = null,
    val abbreviation: Abbreviation? = null,
)

@Serializable
data class Card (
    val id: String,
    val image: String? = null,
    val localId: String? = null,
    val name: String? = null,
)

@Serializable
data class Abbreviation (
    val official: String? = null,
)
@Serializable
data class SeriesBrief(
    val id: String? = null,
    val name: String? = null,
)

@Serializable
data class Series(
    val id: String,
    val logo: String? = null,
    val name: String? = null,
    val sets: ArrayList<Set>? = null,
    val firstSet: FirstSet? = null,
    val lastSet: FirstSet? = null,
    val releaseDate: String? = null,
)

@Serializable
data class FirstSet(
    val cardCount: CardCount? = null,
    val id: String? = null,
    val logo: String? = null,
    val name: String? = null,
    val symbol: String? = null,
)

@Serializable
data class CardCount (
    val firstEd: Int? = null,
    val holo: Int? = null,
    val normal: Int? = null,
    val official: Int? = null,
    val reverse: Int? = null,
    val total: Int? = null,
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