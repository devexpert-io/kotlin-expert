package com.devexperto.kotlinexpert.ui

import androidx.compose.runtime.*
import com.devexperto.kotlinexpert.ui.detail.Detail
import com.devexperto.kotlinexpert.ui.viewmodels.DetailViewModel
import com.devexperto.kotlinexpert.ui.home.Home
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel

@Composable
fun App() {

    var route by remember { mutableStateOf<Route>(Route.Home) }
    val scope = rememberCoroutineScope()

    route.let {
        when (it) {
            Route.Home -> Home(
                vm = HomeViewModel(scope),
                onNoteClick = { noteId -> route = Route.Detail(noteId) }
            )

            is Route.Detail -> Detail(
                vm = DetailViewModel(scope, it.id),
                onClose = { route = Route.Home }
            )
        }
    }

}