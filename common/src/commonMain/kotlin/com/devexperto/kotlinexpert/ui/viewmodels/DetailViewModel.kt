package com.devexperto.kotlinexpert.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.remote.NotesRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val noteId: Long) : ScreenModel {

    var state by mutableStateOf(UiState())
        private set

    init {
        if (noteId != Note.NEW_NOTE) {
            loadNote()
        }
    }

    private fun loadNote() {
        coroutineScope.launch {
            state = UiState(loading = true)
            state = UiState(note = NotesRepository.getById(noteId))
        }
    }

    fun save() {
        coroutineScope.launch {
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
        coroutineScope.launch {
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