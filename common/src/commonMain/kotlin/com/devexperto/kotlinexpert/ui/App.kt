package com.devexperto.kotlinexpert.ui

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.devexperto.kotlinexpert.ui.screens.home.HomeScreen

@Composable
fun App() {
    Navigator(HomeScreen)
}