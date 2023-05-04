package com.devexperto.kotlinexpert.ui.screens.home

import androidx.compose.runtime.Composable
import com.devexperto.kotlinexpert.ui.viewmodels.HomeViewModel

@Composable
expect fun Home(vm: HomeViewModel, onNoteClick: (Long) -> Unit)