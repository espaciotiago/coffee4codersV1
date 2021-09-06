package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.CountryISO
import tech.yeswecode.coffee4codersv1.ui.components.CustomAppBar
import tech.yeswecode.coffee4codersv1.ui.components.TitleText

@Composable
fun DetailScreen(navController: NavController, countryIso: CountryISO) {

    fun onBackPressed() {
        navController.navigate("feed") {
            popUpTo("feed")
        }
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            TitleText(title = "Hola, yo soy el detalle de un producto: ${countryIso.iso}")
        })
}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    DetailScreen(navController = navController, countryIso = CountryISO.COL)
}