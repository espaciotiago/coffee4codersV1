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

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    init {
        getProduct(byId = productId)
    }

    private fun getProduct(byId: Int) {
        _loading.value = true
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val productSelected = Product.list().find { it.id == byId }
                _productVM.value = productSelected?.let { ProductViewModel(product = it) }
                _loading.value = false
            }, 1000)
    }
}