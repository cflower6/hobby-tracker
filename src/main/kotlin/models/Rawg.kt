package com.hobby.tracker.models

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@OptIn(ExperimentalSerializationApi::class)
@JsonIgnoreUnknownKeys
@Serializable
data class RawgResponse(
    @SerialName("count"          ) var count         : Int?               = null,
    @SerialName("next"           ) var next          : String?            = null,
    @SerialName("previous"       ) var previous      : String?            = null,
    @SerialName("results"        ) var results       : ArrayList<Results> = arrayListOf(),
    @SerialName("user_platforms" ) var userPlatforms : Boolean?           = null
)

@Serializable
data class Results (
    @SerialName("slug"               ) var slug             : String?                     = null,
    @SerialName("name"               ) var name             : String?                     = null,
    @SerialName("playtime"           ) var playtime         : Int?                        = null,
    @SerialName("platforms"          ) var platforms        : ArrayList<Platforms>?        = arrayListOf(),
    @SerialName("stores"             ) var stores           : ArrayList<Stores>?           = arrayListOf(),
    @SerialName("released"           ) var released         : String?                     = null,
    @SerialName("tba"                ) var tba              : Boolean?                    = null,
    @SerialName("background_image"   ) var backgroundImage  : String?                     = null,
    @SerialName("rating"             ) var rating           : Double?                     = null,
    @SerialName("rating_top"         ) var ratingTop        : Int?                        = null,
    @SerialName("ratings"            ) var ratings          : ArrayList<Rating>?          = arrayListOf(),
    @SerialName("ratings_count"      ) var ratingsCount     : Int?                        = null,
    @SerialName("reviews_text_count" ) var reviewsTextCount : Int?                        = null,
    @SerialName("added"              ) var added            : Int?                        = null,
    @SerialName("added_by_status"    ) var addedByStatus    : AddedByStatus?              = AddedByStatus(),
    @SerialName("metacritic"         ) var metacritic       : Int?                        = null,
    @SerialName("suggestions_count"  ) var suggestionsCount : Int?                        = null,
    @SerialName("updated"            ) var updated          : String?                     = null,
    @SerialName("id"                 ) var id               : Int?                        = null,
    @SerialName("score"              ) var score            : String?                     = null,
    @SerialName("clip"               ) var clip             : String?                     = null,
    @SerialName("tags"               ) var tags             : ArrayList<Tags>             = arrayListOf(),
    @SerialName("esrb_rating"        ) var esrbRating       : EsrbRating?                 = EsrbRating(),
    @SerialName("user_game"          ) var userGame         : String?                     = null,
    @SerialName("reviews_count"      ) var reviewsCount     : Int?                        = null,
    @SerialName("saturated_color"    ) var saturatedColor   : String?                     = null,
    @SerialName("dominant_color"     ) var dominantColor    : String?                     = null,
    @SerialName("short_screenshots"  ) var shortScreenshots : ArrayList<ShortScreenshots>? = arrayListOf(),
    @SerialName("parent_platforms"   ) var parentPlatforms  : ArrayList<ParentPlatforms>?  = arrayListOf(),
    @SerialName("genres"             ) var genres           : ArrayList<Genres> ?          = arrayListOf(),
    @SerialName("community_rating"   ) var communityRating  : Int?                     = null,
)

@Serializable
data class Platforms (
    @SerialName("platform" ) var platform : Platform? = Platform()
)

@Serializable
data class ParentPlatforms (
    @SerialName("platform" ) var platform : Platform? = Platform()
)

@Serializable
data class Platform (
    @SerialName("id"   ) var id   : Int?    = null,
    @SerialName("name" ) var name : String? = null,
    @SerialName("slug" ) var slug : String? = null
)

@Serializable
data class Store (
    @SerialName("id"   ) var id   : Int?    = null,
    @SerialName("name" ) var name : String? = null,
    @SerialName("slug" ) var slug : String? = null
)

@Serializable
data class Stores (
    @SerialName("store" ) var store : Store? = Store()
)

@Serializable
data class AddedByStatus (
    @SerialName("yet"     ) var yet     : Int? = null,
    @SerialName("owned"   ) var owned   : Int? = null,
    @SerialName("beaten"  ) var beaten  : Int? = null,
    @SerialName("toplay"  ) var toplay  : Int? = null,
    @SerialName("dropped" ) var dropped : Int? = null,
    @SerialName("playing" ) var playing : Int? = null
)

@Serializable
data class ShortScreenshots (
    @SerialName("id"    ) var id    : Int?    = null,
    @SerialName("image" ) var image : String? = null
)

@Serializable
data class Genres (
    @SerialName("id"   ) var id   : Int?    = null,
    @SerialName("name" ) var name : String? = null,
    @SerialName("slug" ) var slug : String? = null
)

@Serializable
data class Rating(
    @SerialName("id"        ) var id : Int?    = null,
    @SerialName("title"     ) var title : String? = null,
    @SerialName("count"     ) var count : Int?    = null,
    @SerialName("percent"   ) var percent : Double?    = null,
)

@Serializable
data class Tags (
    @SerialName("id"               ) var id              : Int?    = null,
    @SerialName("name"             ) var name            : String? = null,
    @SerialName("slug"             ) var slug            : String? = null,
    @SerialName("language"         ) var language        : String? = null,
    @SerialName("games_count"      ) var gamesCount      : Int?    = null,
    @SerialName("image_background" ) var imageBackground : String? = null
)

@Serializable
data class EsrbRating (
    @SerialName("id"      ) var id     : Int?    = null,
    @SerialName("name"    ) var name   : String? = null,
    @SerialName("slug"    ) var slug   : String? = null,
    @SerialName("name_en" ) var nameEn : String? = null,
    @SerialName("name_ru" ) var nameRu : String? = null
)