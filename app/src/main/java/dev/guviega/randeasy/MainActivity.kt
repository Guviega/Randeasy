package dev.guviega.randeasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.guviega.randeasy.ui.theme.RandeasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RandeasyTheme {
                MainScreen()
            }
        }
    }
}