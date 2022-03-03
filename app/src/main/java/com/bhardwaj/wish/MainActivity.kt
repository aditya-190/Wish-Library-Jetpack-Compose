package com.bhardwaj.wish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bhardwaj.wish.ui.theme.WishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WishTheme {
                Wish(
                    title = "Testing",
                    style = WishesStyles.SUCCESS,
                    message = "Wish Testing Here."
                )
            }
        }
    }
}