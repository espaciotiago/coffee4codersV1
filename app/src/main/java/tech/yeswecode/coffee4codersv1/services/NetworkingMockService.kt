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

    }

    override fun loadCities(completion: (cities: List<String>?, error: String?) -> Unit) {

    }

    override fun doPurchase(purchase: Purchase, completion: (ok: String?, error: String?) -> Unit) {

    }

}