package com.devexperto.kotlinexpert.ui.screens.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
@Preview
fun Home(): Unit = with(HomeState) {

    val state by state.collectAsState()

    LaunchedEffect(true) {
        loadNotes(this)
    }

    MaterialTheme {
        Scaffold(topBar = { TopBar() }) { padding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(padding).fillMaxSize()
            ) {
                if (state.loading) {
                    CircularProgressIndicator()
                }

                state.notes?.let { NotesList(it) }
            }
        }
    }
}