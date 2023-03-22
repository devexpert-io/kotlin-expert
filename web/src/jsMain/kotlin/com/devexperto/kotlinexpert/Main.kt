package com.devexperto.kotlinexpert

import com.devexperto.kotlinexpert.ui.App
import com.devexperto.kotlinexpert.ui.theme.AppStyleSheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        App()
    }
}




