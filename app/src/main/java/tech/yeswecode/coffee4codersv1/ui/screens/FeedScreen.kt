package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.*

@Composable
fun FeedScreen(navController: NavController) {
    val list = listOf<CountryISO>(CountryISO.COL, CountryISO.CRI, CountryISO.NIC, CountryISO.BRA)

    Scaffold(
        topBar = { CustomAppBar() }, content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column(modifier = Modifier.padding(16.dp)) {
                        TitleText("Bienvenido")
                        BodyText(body = "Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.")
                    }
                }
                items(list) { country ->
                    ProductCard(name = "Café de Colombia",
                        summary = "Nuestro esfuerzo y trabajo conjunto representa el sueño de amor por las montañas de nuestro país.",
                        price = 35.0,
                        currency = "USD",
                        country = country) {
                        navController.navigate("detail/${country.iso}") {
                            launchSingleTop = true
                        }
                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    FeedScreen(navController = navController)
}