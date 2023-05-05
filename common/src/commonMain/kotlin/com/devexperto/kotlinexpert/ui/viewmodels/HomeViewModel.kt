package com.devexperto.kotlinexpert.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.devexperto.kotlinexpert.data.Filter
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel : ScreenModel {

    var state by mutableStateOf(UiState())
        private set

    init {
        loadNotes()
    }

    private fun loadNotes() {
        coroutineScope.launch {
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