package com.devexperto.kotlinexpert.ui.screens

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
actual fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    androidx.compose.material3.DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        content = content
    )
}

@Composable
actual fun DropdownMenuItem(onClick: () -> Unit, text: @Composable () -> Unit) {
    androidx.compose.material3.DropdownMenuItem(
        onClick = onClick,
        text = text
    )
}