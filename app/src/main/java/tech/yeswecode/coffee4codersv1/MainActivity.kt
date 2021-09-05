package tech.yeswecode.coffee4codersv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import tech.yeswecode.coffee4codersv1.ui.components.CountryISO
import tech.yeswecode.coffee4codersv1.ui.components.ProductCard
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { FeedScreen() }
    }
}

@Composable
fun FeedScreen() {
    Coffee4Codersv1Theme {
        Surface(color = MaterialTheme.colors.background) {
            ProductCard(name = "Café de Colombia",
                summary = "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                price = 35.0,
                currency = "USD",
                country = CountryISO.COL)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    FeedScreen()
}