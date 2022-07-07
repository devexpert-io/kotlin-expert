import Note.Type
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

suspend fun getNotes() = withContext(Dispatchers.IO) {
    delay(2000)
    (0..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
}