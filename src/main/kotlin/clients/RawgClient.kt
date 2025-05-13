package com.hobby.tracker.clients

import com.hobby.tracker.services.ConfigService
import io.ktor.client.*
import io.ktor.client.plugins.logging.*

class RawgClient(
    configService: ConfigService,
    httpClient: HttpClient,
    log: Logger
): BaseClient(httpClient) {
}