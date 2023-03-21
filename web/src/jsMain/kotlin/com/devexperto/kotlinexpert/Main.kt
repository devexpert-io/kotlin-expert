package com.devexperto.kotlinexpert

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.ui.theme.AppStyleSheet
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        val scope = rememberCoroutineScope()
        val homeViewModel = remember { HomeViewModel(scope) }

        NotesList(homeViewModel.state.filteredNotes ?: emptyList()) { note ->
            println(note)
        }
    }
}

@Composable
fun NotesList(notes: List<Note>, onNoteClick: (Note) -> Unit) {
    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
                width(100.percent)
                height(100.percent)
            }
        },

        ) {
        notes.forEach { note ->
            NoteCard(note, onNoteClick)
        }
    }
}

@Composable
fun NoteCard(note: Note, onNoteClick: (Note) -> Unit) {
    Div(
        attrs = {
            classes(AppStyleSheet.noteCard)
            onClick { onNoteClick(note) }
        }
    ) {
        Div(attrs = { classes(AppStyleSheet.noteCardHeader) }) {
            H2(attrs = { classes(AppStyleSheet.noteCardTitle) }) {
                Text(note.title)
            }

            if (note.type == Note.Type.AUDIO) {
                Span(attrs = { style { marginLeft(8.px) } }) {
                    Text("🎤")
                }
            }
        }

        Div {
            Text(note.description)
        }
    }
}


