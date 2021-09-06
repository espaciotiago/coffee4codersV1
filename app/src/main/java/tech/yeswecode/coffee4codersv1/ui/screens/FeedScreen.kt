package tech.yeswecode.coffee4codersv1.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.yeswecode.coffee4codersv1.ui.components.CountryISO
import tech.yeswecode.coffee4codersv1.ui.components.ProductCard
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun FeedScreen() {
    val list = listOf<CountryISO>(CountryISO.COL, CountryISO.CRI, CountryISO.NIC, CountryISO.BRA)

    Coffee4Codersv1Theme {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Bienvenido",
                            style = MaterialTheme.typography.h3)
                        Text("Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Justify)
                    }
                }
                items(list) { country ->
                    ProductCard(name = "Café de Colombia",
                        summary = "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                        price = 35.0,
                        currency = "USD",
                        country = country) {
                        Log.d("FeedScreen", "Selected country: ${country.iso}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}