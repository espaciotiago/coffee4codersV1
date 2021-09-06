package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product

class DetailViewModel(productId: Int) {

    private val emptyProduct = Product(0,"","","",0.0,"","COL")
    private val _productVM = MutableLiveData(ProductViewModel(product = emptyProduct))
    val productVM: LiveData<ProductViewModel> = _productVM

    init {
        getProduct(byId = productId)
    }

    fun getId(): Int {
        return productVM.value?.getId() ?: 0
    }

    fun getName(): String {
        return productVM.value?.getName() ?: ""
    }

    fun getSummary(): String {
        return productVM.value?.getSummary() ?: ""
    }

    fun getDescription(): String {
        return productVM.value?.getDescription() ?: ""
    }

    fun getPrice(): Double {
        return productVM.value?.getPrice() ?: 0.0
    }

    fun getCurrency(): String {
        return productVM.value?.getCurrency() ?: ""
    }

    fun getCountry(): CountryISO {
        return productVM.value?.getCountry() ?: CountryISO.COL
    }

    private fun getProduct(byId: Int) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val productSelected = Product.list().find { it.id == byId }
                _productVM.value = productSelected?.let { ProductViewModel(product = it) }
            }, 1000)
    }
}