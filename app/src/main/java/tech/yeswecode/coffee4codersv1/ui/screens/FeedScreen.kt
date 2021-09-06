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
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.CountryISO
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun FeedScreen(navController: NavController) {
    val product = Product.list()[0]
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
                    ProductCard(ProductViewModel(product)) {
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
    Coffee4Codersv1Theme {
        FeedScreen(navController = navController)
    }
}