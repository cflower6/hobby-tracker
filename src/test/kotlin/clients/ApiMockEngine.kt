package clients

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
//                    "/pokemon/sets" -> respond(HttpStatusCode.OK, headers = responseHeaders)
//                    "/pokemon/rarities" -> respond(HttpStatusCode.OK, headers = responseHeaders)
                    else -> error("Unhandled ${request.url.encodedPath}")
                }
                if (request.url.encodedPath == "/status") {
                    respond(StatusMocksResponse(), HttpStatusCode.OK, headers = responseHeaders)
                } else {
                    error("Unhandled ${request.url.encodedPath}")
                }
            }
        }
    }
}