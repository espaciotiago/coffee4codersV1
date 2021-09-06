package tech.yeswecode.coffee4codersv1.viewModels

import androidx.compose.ui.graphics.Color
import tech.yeswecode.coffee4codersv1.R
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.ui.theme.PlatziBlue
import tech.yeswecode.coffee4codersv1.ui.theme.PlatziGreen

typealias SelectionAction = () -> Unit

enum class CountryISO(val iso: String) {
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        when (this) {
            COL -> return R.drawable.co
            BRA -> return R.drawable.br
            CRI -> return R.drawable.ri
            NIC -> return R.drawable.ni
        }
    }

    fun getCountryFlag(): Int {
        when (this) {
            COL -> return R.drawable.flagco
            BRA -> return R.drawable.flagbr
            CRI -> return R.drawable.flagri
            NIC -> return R.drawable.flagni
        }
    }

    fun getSurfaceColor(): Color {
        when (this) {
            COL, NIC -> return PlatziBlue
            BRA, CRI -> return PlatziGreen
        }
    }
}

class ProductViewModel(product: Product) {
    val product = product

    fun getName(): String {
        return product.name
    }

    fun getSummary(): String {
        return product.summary
    }

    fun getDescription(): String {
        return product.description
    }

    fun getPrice(): Double {
        return product.price
    }

    fun getCurrency(): String {
        return product.currency
    }

    fun getCountry(): CountryISO {
        return CountryISO.valueOf(product.countryISO)
    }
}