package tech.yeswecode.coffee4codersv1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.CountryISO
import tech.yeswecode.coffee4codersv1.viewModels.SelectionAction

@Composable
fun ProductCard(name: String,
                summary: String,
                price: Double,
                currency: String,
                country: CountryISO,
                selected: SelectionAction) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable {
            selected()
        }
        .size(480.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 10.dp,
    ) {
        Image(
            painter = painterResource(id = country.getBackgroundImage()),
            contentDescription = null
        )
        Surface(
            color = country.getSurfaceColor().copy(alpha = 0.2f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = summary,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(){
                        Image(painter = painterResource(id = country.getCountryFlag()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp, 32.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "$ $price $currency",
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    Coffee4Codersv1Theme {
        ProductCard(name = "Café de Nicaragua",
            summary = "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
            price = 35.0,
            currency = "USD",
            country = CountryISO.NIC) {}
    }
}