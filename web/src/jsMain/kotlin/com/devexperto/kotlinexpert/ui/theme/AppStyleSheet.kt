package com.devexperto.kotlinexpert.ui.theme

import org.jetbrains.compose.web.css.*

object AppStyleSheet : StyleSheet() {

    val noteCard by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        width(80.percent)
        maxWidth(600.px)
        marginTop(8.px)
        marginBottom(8.px)
        border(1.px, LineStyle.Solid, Color.black)
        borderRadius(4.px)
        padding(16.px)
        cursor("pointer")
    }

    val noteCardHeader by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Row)
        alignItems(AlignItems.Center)
        width(100.percent)
    }

    val noteCardTitle by style {
        flex(1)
        lineHeight(1.5.em)
        margin(0.px)
    }
}