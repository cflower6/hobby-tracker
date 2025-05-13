package clients

import PokemonRaritiesMocksResponse
import PokemonSelectSeriesMocksResponse
import PokemonSeriesMocksResponse
import PokemonSetMocksResponse
import PokemonSetsMockResponse
import StatusMocksResponse
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*

class ApiMockEngine {
    fun get() = client.engine
    private val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
    private val client = HttpClient(MockEngine) {
        install(Logging)
        engine {
            addHandler { request ->
                when (request.url.encodedPath) {
                    "/status" -> respond(StatusMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    "/pokemon/sets" -> respond(PokemonSetsMockResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    "/pokemon/set/{setName}" -> respond(PokemonSetMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    "/pokemon/series" -> respond(PokemonSeriesMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    "/pokemon/series/{setName}" -> respond(PokemonSelectSeriesMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    "/pokemon/rarities" -> respond(PokemonRaritiesMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                    else -> error("Unhandled ${request.url.encodedPath}")
                }
            }
        }
    }
}