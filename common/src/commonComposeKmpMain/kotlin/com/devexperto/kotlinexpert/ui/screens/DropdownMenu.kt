package com.devexperto.kotlinexpert.ui.screens

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
expect fun DropdownMenu(expanded: Boolean, onDismissRequest: () -> Unit, content: @Composable ColumnScope.() -> Unit)

@Composable
expect fun DropdownMenuItem(onClick: () -> Unit, text: @Composable () -> Unit)