package com.devexperto.kotlinexpert.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.devexperto.kotlinexpert.ui.screens.detail.DetailScreen
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel

object HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Home(
            vm = HomeViewModel(rememberCoroutineScope()),
            onNoteClick = { navigator.push(DetailScreen(it)) }
        )
    }

}

@Composable
expect fun Home(vm: HomeViewModel, onNoteClick: (Long) -> Unit)