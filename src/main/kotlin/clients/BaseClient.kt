package com.hobby.tracker.clients

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

abstract class BaseClient(
    private val httpClient: HttpClient,
) {
    suspend fun baseClient(httpVerb: String, vararg pathSegments: String, endpoint: String): HttpResponse {
        val response: HttpResponse = httpClient.request(endpoint) {
            method = when (httpVerb) {
                "GET" -> HttpMethod.Get
                "POST" -> HttpMethod.Post
                "PUT" -> HttpMethod.Put
                "DELETE" -> HttpMethod.Delete
                "PATCH" -> HttpMethod.Patch
                "HEAD" -> HttpMethod.Head
                "OPTIONS" -> HttpMethod.Options
                else -> throw IllegalArgumentException("unknown http verb: $httpVerb")
            }
            url {
                appendPathSegments(*pathSegments)
            }
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json)
                append(HttpHeaders.ContentType, ContentType.Application.Json)
            }
        }
        return response
    }
}