package com.devexperto.kotlinexpert

import com.devexperto.kotlinexpert.ui.App
import com.devexperto.kotlinexpert.ui.theme.AppStyleSheet
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.renderComposable

fun main() {
    composeSample()
    kotlinJsSample()
}

private fun composeSample() {
    document.getElementById("root") ?: return
    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)
        App()
    }
}

private fun kotlinJsSample() {
    window.onload = {
        val message = document.getElementById("message")
        if (message != null) {
            message.textContent = "Hello, Kotlin/JS!"

            val button = document.getElementById("button")!!
            button.addEventListener("click", {
                window.alert("You clicked the button!")
            })
        }
    }
}




