package com.devexperto.kotlinexpert

import com.devexperto.kotlinexpert.Note.Type
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

fun getNotes() = flow {
    delay(2000)
    val notes = (0..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
    emit(notes)
}