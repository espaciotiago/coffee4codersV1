package tech.yeswecode.coffee4codersv1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.components.*
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.DetailViewModel
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel

@Composable
fun DetailScreen(navController: NavController, detailVM: DetailViewModel) {
    val emptyProduct = Product(0,"","","",0.0,"","COL")
    val product = detailVM.productVM.observeAsState(ProductViewModel(product = emptyProduct))
    val loading = detailVM.loading.observeAsState(false)
    val error = detailVM.errorMessage.observeAsState(null)

    fun onBackPressed() {
        navController.navigate("feed") {
            popUpTo("feed")
        }
    }

    Scaffold(
        topBar = { CustomAppBar(navigationIcon = Icons.Filled.ArrowBack) {
            onBackPressed()
        } }, content = {
            when {
                loading.value -> {
                    Loader()
                }
                error.value != null -> {
                    ErrorView(errorMessage = error.value!!) {
                        detailVM.getProduct()
                    }
                }
                else -> {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                        ) {
                            Image(
                                painter = painterResource(
                                    id = product.value.getCountry().getBackgroundImage()
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Column(modifier = Modifier.padding(16.dp)) {
                            TitleText(title = product.value.getName())
                            Text(
                                product.value.getSummary(),
                                style = MaterialTheme.typography.caption
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            BodyText(body = product.value.getDescription())
                            Spacer(modifier = Modifier.height(24.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                                Text(
                                    text = "$ ${product.value.getPrice()} ${product.value.getCurrency()}",
                                    style = MaterialTheme.typography.h5,
                                    textAlign = TextAlign.Start
                                )

                                CustomButton(label = "Continuar") {
                                    navController.navigate("checkout/${product.value.getId()}") {
                                        launchSingleTop = true
                                    }
                                }
                            }
                        }
                    }
                }
            }
        })
}

@Preview(
    showBackground = true
)
@Composable
fun DetailScreenPreview() {
    val navController = rememberNavController()
    Coffee4Codersv1Theme {
        DetailScreen(navController = navController, detailVM = DetailViewModel(0))
    }
}