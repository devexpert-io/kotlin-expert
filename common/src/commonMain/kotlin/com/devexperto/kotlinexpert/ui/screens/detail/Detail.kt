package com.devexperto.kotlinexpert.ui.screens.detail

import androidx.compose.runtime.Composable
import com.devexperto.kotlinexpert.ui.viewmodels.DetailViewModel

@Composable
expect fun Detail(vm: DetailViewModel, onClose: () -> Unit)