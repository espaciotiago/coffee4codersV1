package tech.yeswecode.coffee4codersv1.services

import android.os.Handler
import android.os.Looper
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.models.Purchase

class NetworkingMockService: NetworkingInterface {
    override fun loadFeed(completion: (feed: List<Product>?, error: String?) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                completion(Product.list(), null)
            }, 1000)
    }

    override fun getProduct(id: Int, completion: (product: Product?, error: String?) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val product = Product.list().find { it.id == id }
                completion(product, null)
            }, 500)
    }

    override fun loadCities(completion: (cities: List<String>?, error: String?) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val cities = Purchase.cities().map { it }
                completion(cities, null)
            }, 500)
    }

    override fun doPurchase(purchase: Purchase, completion: (ok: String?, error: String?) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                completion("El pedido fue realizado satisfactoriamente", null)
            }, 500)
    }

}