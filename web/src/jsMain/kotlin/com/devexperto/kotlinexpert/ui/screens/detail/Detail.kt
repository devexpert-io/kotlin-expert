package com.devexperto.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.Composable
import com.devexperto.kotlinexpert.ui.viewmodels.DetailViewModel
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Detail(vm: DetailViewModel, onClose: () -> Unit) {
    Div { Text("Detail") }
}