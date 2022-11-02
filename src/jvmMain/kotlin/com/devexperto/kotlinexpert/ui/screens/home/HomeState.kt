package com.devexperto.kotlinexpert.ui.screens.home

import com.devexperto.kotlinexpert.data.Filter
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.data.remote.notesClient
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object HomeState {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            val response = notesClient.request("http://localhost:8080/notes")
            println(response.body() as String)
        }
    }

    fun onFilterClick(filter: Filter) {
        _state.update { it.copy(filter = filter) }
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