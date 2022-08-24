package com.devexperto.kotlinexpert.ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("My Notes") },
        actions = { FiltersAction() }
    )
}

@Composable
private fun FiltersAction() {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {

        Icon(imageVector = Icons.Default.FilterList, contentDescription = "Filter")

        DropdownMenu(expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("All")
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("Text")
            }
            DropdownMenuItem(onClick = { expanded = false }) {
                Text("Audio")
            }
        }
    }
}