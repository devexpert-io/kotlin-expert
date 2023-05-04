package com.devexperto.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.devexperto.kotlinexpert.ui.viewmodels.DetailViewModel

data class DetailScreen(val noteId: Long) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Detail(
            vm = DetailViewModel(rememberCoroutineScope(), noteId),
            onClose = { navigator.pop() })
    }

}

@Composable
expect fun Detail(vm: DetailViewModel, onClose: () -> Unit)