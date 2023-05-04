package com.devexperto.kotlinexpert.ui.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLSpanElement

@Composable
fun Icon(iconName: String, attrs: (AttrsScope<HTMLSpanElement>.() -> Unit)? = null) {
    Span(
        attrs = {
            classes("material-icons")
            attrs?.invoke(this)
        }
    ) {
        Text(iconName)
    }
}