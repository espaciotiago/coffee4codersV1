package tech.yeswecode.coffee4codersv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffee4codersv1.ui.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { InitialScreen() }
    }
}

@Composable
fun InitialScreen() {
    FeedScreen()
}

@Preview(
    showBackground = true
)
@Composable
fun InitailScreenPreview() {
    InitialScreen()
}