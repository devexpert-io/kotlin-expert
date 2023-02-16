package com.devexperto.kotlinexpert

expect fun getPlatformName(): String

fun getAppTitle(): String = "My Notes - ${getPlatformName()}"