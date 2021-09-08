package tech.yeswecode.coffee4codersv1.utilities

import androidx.compose.ui.graphics.Color
import tech.yeswecode.coffee4codersv1.R
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