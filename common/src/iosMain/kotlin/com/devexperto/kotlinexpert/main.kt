package com.devexperto.kotlinexpert

import androidx.compose.ui.window.ComposeUIViewController
import com.devexperto.kotlinexpert.ui.App
import platform.UIKit.UIViewController

@Suppress("unused", "FunctionName")
fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}