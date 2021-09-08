package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.FeedViewModel
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun FeedScreen(navController: NavController, feedVM: FeedViewModel = FeedViewModel()) {
    val feed = feedVM.feed.observeAsState(ArrayList())
    val loading = feedVM.loading.observeAsState(false)
    val error = feedVM.errorMessage.observeAsState(null)

    Scaffold(
        topBar = { CustomAppBar() }, content = {
            when {
                loading.value -> {
                    Loader()
                }
                error.value != null -> {
                    ErrorView(errorMessage = error.value!!) {
                        feedVM.loadFeed()
                    }
                }
                feed.value.isEmpty() -> {
                    EmptyView {
                        feedVM.loadFeed()
                    }
                }
                else -> {
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
                                navController.navigate("detail/${p.getId()}") {
                                    launchSingleTop = true
                                }
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