package com.devexperto.kotlinexpert

import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.devexperto.kotlinexpert.ui.screens.home.Home
import com.devexperto.kotlinexpert.ui.theme.AppStyleSheet
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        val scope = rememberCoroutineScope()
        val homeViewModel = remember { HomeViewModel(scope) }

        Home(homeViewModel) { noteId ->
            println("Note clicked: $noteId")
        }
    }
}




