package com.devexperto.kotlinexpert.ui.screens.home


import androidx.compose.runtime.Composable
import com.devexperto.kotlinexpert.data.Note
import com.devexperto.kotlinexpert.ui.theme.AppStyleSheet
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit) {
    Div(attrs = {
        style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            width(100.percent)
            height(100.percent)
        }
    }

    ) {
        TopBar(onFilterClick = vm::onFilterClick)

        Div {

            if (vm.state.loading) {
                Text("Cargando...")
            }

            vm.state.filteredNotes?.let { notes ->
                NotesList(
                    notes = notes,
                    onNoteClick = { onNoteClick(it.id) }
                )
            }
        }

        Div(
            attrs = {
                classes(AppStyleSheet.fab)
                onClick { onNoteClick(Note.NEW_NOTE) }
            }
        ) {
            Text("+")
        }
    }
}