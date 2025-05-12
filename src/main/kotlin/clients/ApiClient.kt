package com.hobby.tracker.clients

import com.hobby.tracker.helper.TrustAllX509TrustManager
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.apache5.*
import io.ktor.client.plugins.logging.*
import java.security.SecureRandom
import javax.net.ssl.SSLContext

class ApiClient {
    private lateinit var client: HttpClient;

    private fun setSSLConfigFlavor(engine: HttpClientEngine, sslPin: String?) {
        when(sslPin) {
            "Apache5" -> {
                client = HttpClient(Apache5) {
                    install(Logging)
                    engine {
                        sslContext = SSLContext.getInstance("TLS").apply {
                            init(null, arrayOf(TrustAllX509TrustManager()), SecureRandom())
                        }
                    }
                }
            }
            else -> {
                client = HttpClient(engine) {
                    install(Logging)
                }
            }
        }
    }

    /**
     * We only want one instance so we close the client regardless of if it's created
     */
    fun createClient(engine: HttpClientEngine, sslPin: String?): HttpClient {
        setSSLConfigFlavor(engine, sslPin)
        return client
    }
}