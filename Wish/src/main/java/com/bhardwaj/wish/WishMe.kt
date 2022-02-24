package com.bhardwaj.wish

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier

@Composable
fun Wish(
    modifier: Modifier = Modifier(),
    title: String? = null,
    message: String,
    shape: Shape = MaterialTheme.shapes.small,
    style: WishesStyles,
    backgroundColor: Color = SnackbarDefaults.backgroundColor,
    contentColor: Color = MaterialTheme.colors.surface,
    elevation: Dp = 6.dp,
    duration: Long = 2000L,
    actionOnNewLine: Boolean = false,
    action: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {

}