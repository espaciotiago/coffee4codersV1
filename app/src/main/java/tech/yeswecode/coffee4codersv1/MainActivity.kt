package tech.yeswecode.coffee4codersv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.CountryISO
import tech.yeswecode.coffee4codersv1.ui.screens.CheckoutScreen
import tech.yeswecode.coffee4codersv1.ui.screens.DetailScreen
import tech.yeswecode.coffee4codersv1.ui.screens.FeedScreen
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavigationHost() }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffee4Codersv1Theme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable("feed") { FeedScreen(navController = navController) }
                composable("detail/{countryIso}") { backStackEntry ->
                    val countryIsoString = backStackEntry.arguments?.getString("countryIso") ?: "COL"
                    val countryIso = CountryISO.valueOf(countryIsoString)
                    DetailScreen(navController = navController, country = countryIso)
                }
                composable("checkout/{countryIso}") { backStackEntry ->
                    val countryIsoString = backStackEntry.arguments?.getString("countryIso") ?: "COL"
                    val countryIso = CountryISO.valueOf(countryIsoString)
                    CheckoutScreen(navController = navController, country = countryIso)
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun NavigationHostPreview() {
    NavigationHost()
}