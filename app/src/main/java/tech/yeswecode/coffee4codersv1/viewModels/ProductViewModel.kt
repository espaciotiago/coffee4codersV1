package tech.yeswecode.coffee4codersv1.viewModels

import tech.yeswecode.coffee4codersv1.models.Product

class ProductViewModel(product: Product) {
    val product = product

    fun getId(): Int {
        return product.id
    }

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