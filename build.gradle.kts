val kotlin_version: String by project
val logback_version: String by project
val ktor_version: String by project
val kgraphql_version: String by project

plugins {
    kotlin("jvm") version "2.1.10"
    id("io.ktor.plugin") version "3.1.2"
    kotlin("plugin.serialization") version "2.1.20"
}

group = "com.hobby.tracker"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-client-apache5:$ktor_version")
    implementation("io.ktor:ktor-client-core")
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty")
    implementation("com.apurebase:kgraphql:$kgraphql_version")      // <-- Add these two lines
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")

    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")


    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-config-yaml")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("io.ktor:ktor-client-mock:$ktor_version")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
