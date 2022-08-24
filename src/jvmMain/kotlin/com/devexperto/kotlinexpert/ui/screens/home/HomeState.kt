package com.devexperto.kotlinexpert.ui.screens.home

import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.getNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object HomeState {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState(loading = true)
            getNotes().collect {
                _state.value = UiState(notes = it)
            }
        }
    }

    data class UiState(
        val notes: List<Note>? = null, val loading: Boolean = false
    )
}