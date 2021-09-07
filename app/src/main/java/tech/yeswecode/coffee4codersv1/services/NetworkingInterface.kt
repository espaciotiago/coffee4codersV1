package tech.yeswecode.coffee4codersv1.services

import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.models.Purchase

interface NetworkingInterface {
    fun loadFeed(completion: (feed: List<Product>?, error: String?) -> Unit)
    fun getProduct(id: Int, completion: (product: Product?, error: String?) -> Unit)
    fun loadCities(completion: (cities: List<String>?, error: String?) -> Unit)
    fun doPurchase(purchase: Purchase, completion: (ok: String?, error: String?) -> Unit)
}