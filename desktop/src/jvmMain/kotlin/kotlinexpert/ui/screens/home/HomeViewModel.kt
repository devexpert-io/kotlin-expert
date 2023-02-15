package kotlinexpert.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinexpert.data.Filter
import kotlinexpert.data.Note
import kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(private val scope: CoroutineScope) {

    var state by mutableStateOf(UiState())
        private set

    init {
        loadNotes()
    }

    private fun loadNotes() {
        scope.launch {
            state = UiState(loading = true)
            val response = NotesRepository.getAll()
            state = UiState(notes = response)
        }
    }

    fun onFilterClick(filter: Filter) {
        state = state.copy(filter = filter)
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All,
    ) {
        val filteredNotes: List<Note>?
            get() = notes?.let {
                when (filter) {
                    Filter.All -> notes
                    is Filter.ByType -> notes.filter { it.type == filter.type }
                }
            }
    }
}