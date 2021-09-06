package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

@Composable
fun CheckoutScreen(navController: NavController, country: CountryISO) {

    fun onBackPressed() {
        navController.navigate("detail/${country.iso}")
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            CustomButton(label = "Finalizar compra") {
                navController.navigate("feed") {
                    launchSingleTop = true
                    popUpTo("feed")
                }
            }
        })
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffee4Codersv1Theme {
        CheckoutScreen(navController = navController, country = CountryISO.COL)
    }
}