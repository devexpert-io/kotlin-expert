package kotlinexpert.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

val notesClient = HttpClient() {
    install(ContentNegotiation) {
        json()
    }
}