package com.devexperto.kotlinexpert

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.devexperto.kotlinexpert.ui.App

fun main() {
    application {
        Window(onCloseRequest = ::exitApplication, title = getAppTitle()) {
            App()
        }
    }
}
