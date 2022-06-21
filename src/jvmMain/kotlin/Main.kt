// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

class AppState {
    val text = mutableStateOf("")
    val buttonEnabled get() = text.value.isNotEmpty()
}

@Composable
@Preview
fun App(appState: AppState) {

    MaterialTheme {
        Column {
            TextField(value = appState.text.value, onValueChange = { newText -> appState.text.value = newText })
            Text(text = buildMessage(appState.text.value))
            Button(
                onClick = { appState.text.value = "" }, enabled = appState.buttonEnabled
            ) {
                Text("Clean")
            }
        }
    }
}

fun buildMessage(name: String): String = "Hello $name"

fun main() {
    val appState = AppState()

    application {
        Window(onCloseRequest = ::exitApplication) {
            App(appState)
        }
    }
}
