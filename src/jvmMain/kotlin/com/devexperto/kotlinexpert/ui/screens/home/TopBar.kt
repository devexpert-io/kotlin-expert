package com.devexperto.kotlinexpert.ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.devexperto.kotlinexpert.data.Filter
import com.devexperto.kotlinexpert.data.Note

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    TopAppBar(
        title = { Text("My Notes") },
        actions = { FiltersAction(onFilterClick) }
    )
}

@Composable
private fun FiltersAction(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {

        Icon(imageVector = Icons.Default.FilterList, contentDescription = "Filter")

        DropdownMenu(expanded, onDismissRequest = { expanded = false }) {
            listOf(
                Filter.All to "All",
                Filter.ByType(Note.Type.TEXT) to "Text",
                Filter.ByType(Note.Type.AUDIO) to "Audio"
            ).forEach { (filter, text) ->
                DropdownMenuItem(onClick = {
                    onFilterClick(filter)
                    expanded = false
                }) {
                    Text(text)
                }
            }
        }
    }
}