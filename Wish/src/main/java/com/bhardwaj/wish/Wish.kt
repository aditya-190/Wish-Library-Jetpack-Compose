package com.bhardwaj.wish

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bhardwaj.wish.ui.theme.Shapes
import com.bhardwaj.wish.ui.theme.backgroundColor
import com.bhardwaj.wish.ui.theme.contentColor
import com.bhardwaj.wish.ui.theme.successColor

@Composable
fun Wish(
    modifier: Modifier = Modifier,
    title: String? = null,
    message: String,
    shape: Shape = MaterialTheme.shapes.medium,
    style: WishesStyles = WishesStyles.SUCCESS,
    backgroundColor: Color = MaterialTheme.colors.backgroundColor,
    contentColor: Color = MaterialTheme.colors.contentColor,
    elevation: Dp = 6.dp,
    duration: Long = 2000L,
    actionOnNewLine: Boolean = false,
    action: @Composable (() -> Unit)? = null,
    content: @Composable (() -> Unit)? = null
) {

    Snackbar(
        modifier = modifier,
        action = action,
        actionOnNewLine = actionOnNewLine,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2F)
                .padding(all = 16.dp)
                .clip(Shapes.large)
                .background(color = backgroundColor)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .clip(Shapes.medium)
                    .background(color = successColor)
            )

            Box {
                Row {
                    Image(
                        modifier = Modifier.clip(CircleShape),
                        painter = painterResource(id = R.drawable.icon_success),
                        contentDescription = "Vector"
                    )

                    Column {
                        Text(text = "Title")
                        Text(text = "Message That Needs to be displayed.")
                    }
                }
            }
        }
    }
}