package com.bhardwaj.wish

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhardwaj.wish.ui.theme.*

@Composable
fun Wish(
    modifier: Modifier = Modifier,
    title: String? = null,
    message: String,
    style: WishesStyles,
    shape: Shape = MaterialTheme.shapes.medium,
    actionOnNewLine: Boolean = false,
    action: @Composable (() -> Unit)? = null,
) {
    val wishColor: Color
    val wishIcon: Painter
    val coloredList = listOf(
        WishesStyles.COLORED_SUCCESS,
        WishesStyles.COLORED_INFORMATION,
        WishesStyles.COLORED_WARNING,
        WishesStyles.COLORED_ERROR,
        WishesStyles.COLORED_DELETE,
        WishesStyles.COLORED_NO_INTERNET
    )

    when (style) {
        WishesStyles.SUCCESS, WishesStyles.COLORED_SUCCESS -> {
            wishColor = successColor
            wishIcon = painterResource(id = R.drawable.icon_success)
        }
        WishesStyles.INFORMATION, WishesStyles.COLORED_INFORMATION -> {
            wishColor = infoColor
            wishIcon = painterResource(id = R.drawable.icon_info_blue)
        }
        WishesStyles.WARNING, WishesStyles.COLORED_WARNING -> {
            wishColor = warningColor
            wishIcon = painterResource(id = R.drawable.icon_warning)
        }
        WishesStyles.ERROR, WishesStyles.COLORED_ERROR -> {
            wishColor = errorColor
            wishIcon = painterResource(id = R.drawable.icon_error)
        }
        WishesStyles.DELETE, WishesStyles.COLORED_DELETE -> {
            wishColor = deleteColor
            wishIcon = painterResource(id = R.drawable.icon_delete)
        }
        WishesStyles.NO_INTERNET, WishesStyles.COLORED_NO_INTERNET -> {
            wishColor = warningColor
            wishIcon = painterResource(id = R.drawable.icon_internet)
        }
    }

    Snackbar(
        modifier = modifier
            .fillMaxHeight(0.2F)
            .padding(all = 12.dp),
        action = action,
        actionOnNewLine = actionOnNewLine,
        shape = shape,
        backgroundColor = wishColor.copy(alpha = 0F),
        contentColor = wishColor.copy(alpha = 0F),
        elevation = 0.dp
    ) {
        if (style in coloredList) {
            ColoredWish(
                title = title,
                message = message,
                wishColor = wishColor,
                wishIcon = wishIcon
            )
        } else {
            SimpleWish(
                title = title,
                message = message,
                wishColor = wishColor,
                wishIcon = wishIcon
            )
        }
    }
}

@Composable
private fun SimpleWish(
    title: String?,
    message: String,
    wishColor: Color,
    wishIcon: Painter
) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1F,
        targetValue = 0.7F,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        )
    )

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(12.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = wishColor)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 8.dp
                    )
                )
                .background(color = wishColor.copy(alpha = 0.2F))

        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = wishIcon,
                    contentDescription = "Wish Icon",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .scale(scale)
                        .padding(start = 8.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 12.dp, end = 12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    if (title != null) {
                        Text(
                            text = title.trim().uppercase(),
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = TextStyle(
                                color = wishColor,
                                fontFamily = montserrat,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 2.sp,
                                fontSize = 12.sp
                            )
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        text = message.trim(),
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun ColoredWish(
    title: String?,
    message: String,
    wishColor: Color,
    wishIcon: Painter
) {
    val infiniteTransition = rememberInfiniteTransition()
    val scale by infiniteTransition.animateFloat(
        initialValue = 1F,
        targetValue = 0.7F,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(color = wishColor)

    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = wishIcon,
                contentDescription = "Wish Icon",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .scale(scale)
                    .padding(start = 8.dp)
                    .background(Color.White)
                    .padding(8.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                if (title != null) {
                    Text(
                        text = title.trim().uppercase(),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyle(
                            color = Color.White,
                            fontFamily = montserrat,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp,
                            fontSize = 12.sp
                        )
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    text = message.trim(),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = montserrat,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}