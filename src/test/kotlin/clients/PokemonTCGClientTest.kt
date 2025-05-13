package clients

import StatusMocksResponse
import com.hobby.tracker.clients.ApiClient
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class PokemonTCGClientTest {
    private val apiMockEngine = ApiMockEngine()
    private val apiMock = ApiClient()
    private var apiClient: HttpClient? = null

    @BeforeEach
    fun setup() {
        apiClient = apiMock.createClient(apiMockEngine.get(), null)
    }

    @Test
    fun test() = runBlocking {
        val status = apiClient?.get("http://localhost/status") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (status != null) {
            assertEquals(StatusMocksResponse(), status.bodyAsText())
        }
    }

    @Test
    fun test_pokemon_sets() = runBlocking {
        val pokemonSets = apiClient?.get("http://localhost/pokemon/sets") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (pokemonSets != null) {
            assertEquals(HttpStatusCode.OK, pokemonSets.status)
        }
    }

    @Test
    fun test_pokemon_set() = runBlocking {
        val pokemonSet = apiClient?.get("http://localhost/pokemon/sets/testSetName") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (pokemonSet != null) {
            assertEquals(HttpStatusCode.OK, pokemonSet.status)
        }
    }

    @Test
    fun test_pokemon_series() = runBlocking {
        val pokemonSeries = apiClient?.get("http://localhost/pokemon/series") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (pokemonSeries != null) {
            assertEquals(HttpStatusCode.OK, pokemonSeries.status)
        }
    }

    @Test
    fun test_pokemon_select_series() = runBlocking {
        val pokemonSelectSeries = apiClient?.get("http://localhost/pokemon/series/testSeriesName") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (pokemonSelectSeries != null) {
            assertEquals(HttpStatusCode.OK, pokemonSelectSeries.status)
        }
    }

    @Test
    fun test_pokemon_rarities() = runBlocking {
        val pokemonRarities = apiClient?.get("http://localhost/pokemon/rarities") {
            contentType(ContentType.Application.Json)
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json)
                append(HttpHeaders.Accept, ContentType.Application.Json)
            }
        }

        if (pokemonRarities != null) {
            assertEquals(HttpStatusCode.OK, pokemonRarities.status)
        }
    }
}