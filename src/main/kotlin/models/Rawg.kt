package com.hobby.tracker.models

data class RawgResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: ArrayList<Result>,
    val filters: ArrayList<Filter>,
)

data class Result(
    val id: Int,
    val slug: String,
    val name: String,
    val released: String,
    val tba: Boolean,
    val background_image: String,
    val rating: Double,
    val rating_top: Int,
    val ratings: Array<Rating>,
    val ratings_count: Int,
    val reviews_text_count: Int,
    val added: Int,
    val added_by_status: ArrayList<AddedByStatus>,
    val metacritic: Int,
    val playtime: Int,
    val suggestions_count: Int,
    val updated: String,
    val user_game: String,
    val reviews_count: Int,
    val saturated_color: String,
    val dominant_color: String,
    val platforms: ArrayList<Platform>,
    val parent_platforms: ArrayList<Platform>,
    val genres: ArrayList<Genre>,
    val stores: ArrayList<Store>,
    val clip: String,
    val tags: ArrayList<Tag>,
    val esrb_rating: ESBRating,
    val short_screenshots: ArrayList<ShortScreenshot>,
)

data class Filter(
    val count: Int,
)

data class Rating(
    val id: Int,
    val title: String,
    val count: Int,
    val percentage: Double,
)

data class AddedByStatus(
    val id: Int,
)

data class Platform(
    val id: Int,
)

data class Genre(
    val id: Int,
)

data class Store(
    val id: Int,
)
data class Tag(
    val id: Int,
)
data class ESBRating(
    val id: Int,
)

data class ShortScreenshot(
    val id: Int,
)