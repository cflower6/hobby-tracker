import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        environment {
            config = ApplicationConfig("applicationTest.yaml")
        }

        val response = client.get("http://localhost:80/status") {
            headers {
                append(HttpHeaders.Accept, ContentType.Application.Json)
                append(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded)
            }
        }

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("{\n    \"status\": \"OK\"\n}", response.bodyAsText())
    }
}