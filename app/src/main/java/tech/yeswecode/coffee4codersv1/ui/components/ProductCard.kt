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
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.theme.Coffee4Codersv1Theme
import tech.yeswecode.coffee4codersv1.viewModels.ProductViewModel
import tech.yeswecode.coffee4codersv1.viewModels.SelectionAction

@Composable
fun ProductCard(productVM: ProductViewModel,
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
            painter = painterResource(id = productVM.getCountry().getBackgroundImage()),
            contentDescription = null
        )
        Surface(
            color = productVM.getCountry().getSurfaceColor().copy(alpha = 0.2f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = productVM.getName(),
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = productVM.getSummary(),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(){
                        Image(painter = painterResource(id = productVM.getCountry().getCountryFlag()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp, 32.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "$ ${productVM.getPrice()} ${productVM.getCurrency()}",
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

    val product = Product.list()[0]

    Coffee4Codersv1Theme {
        ProductCard(ProductViewModel(product = product)) {}
    }
}