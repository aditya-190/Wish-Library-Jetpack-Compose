package com.bhardwaj.wish.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFFBC02D)
val Purple500 = Color(0xFF0340DA)
val Purple700 = Color(0xFF17B978)
val Teal200 = Color(0xFFD50000)

val warningColor = Color(0xFFFBC02D)
val errorColor = Color(0xFFD50000)
val successColor = Color(0xFF17B978)
val infoColor = Color(0xFF0340DA)
val deleteColor = Color(0xFF0288D1)

val Colors.backgroundColor
    @Composable
    get() = if (isLight) Color(0xFFEEECEC) else Color(0xFF2F3032)

val Colors.contentColor
    @Composable
    get() = if (isLight) Color(0xFF2F3032) else Color(0xFFEEECEC)