package com.devexperto.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DetailViewModel(private val scope: CoroutineScope, private val noteId: Long) {

    var state by mutableStateOf(UiState())
        private set

    init {
        if (noteId != Note.NEW_NOTE) {
            loadNote()
        }
    }

    private fun loadNote() {
        scope.launch {
            state = UiState(loading = true)
            state = UiState(note = NotesRepository.getById(noteId))
        }
    }

    fun save() {
        scope.launch {
            val note = state.note
            if (note.id == Note.NEW_NOTE) {
                NotesRepository.save(note)
            } else {
                NotesRepository.update(note)
            }
            state = state.copy(saved = true)
        }
    }

    fun update(note: Note) {
        state = state.copy(note = note)
    }

    fun delete() {
        scope.launch {
            NotesRepository.delete(state.note)
            state = state.copy(saved = true)
        }
    }

    data class UiState(
        val note: Note = Note("", "", Note.Type.TEXT),
        val loading: Boolean = false,
        val saved: Boolean = false
    )
}