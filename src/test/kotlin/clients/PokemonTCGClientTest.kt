package clients

import StatusMocksResponse
import com.hobby.tracker.Status
import com.hobby.tracker.clients.ApiClient
import io.ktor.client.*
import io.ktor.client.call.*
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
}