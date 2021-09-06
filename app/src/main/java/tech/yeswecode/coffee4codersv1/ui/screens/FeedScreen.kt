package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.CountryISO
import tech.yeswecode.coffee4codersv1.viewModels.FeedViewModel
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun FeedScreen(navController: NavController, feedVM: FeedViewModel = FeedViewModel()) {
    val feed = feedVM.feed.observeAsState(ArrayList())

    Scaffold(
        topBar = { CustomAppBar() }, content = {
            if(feed.value.isEmpty()){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Column(modifier = Modifier.padding(16.dp)) {
                            TitleText("Bienvenido")
                            BodyText(body = "Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.. Lorem ipsum dolor sit amet consectetur adipiscing elit per, nullam semper nisl aliquet quisque curae vestibulum.")
                        }
                    }
                    items(feed.value) { p ->
                        ProductCard(ProductViewModel(p.product)) {
                            navController.navigate("detail/${p.getCountry().iso}") {
                                launchSingleTop = true
                            }
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