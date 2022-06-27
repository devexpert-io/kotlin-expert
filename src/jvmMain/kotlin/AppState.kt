import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

class AppState {
    val state = mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            state.value = UiState(loading = true)
            getNotes { state.value = UiState(notes = it) }
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}