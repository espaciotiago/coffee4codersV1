package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.services.NetworkingInterface
import tech.yeswecode.coffee4codersv1.services.NetworkingMockService

class DetailViewModel(productId: Int, service: NetworkingInterface = NetworkingMockService()) {

    private val service: NetworkingInterface = service
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
        service.getProduct(byId) { product, error ->
            if (error != null) {
                //TODO: Handle error
            } else {
                _productVM.value = product?.let { ProductViewModel(product = it) }
            }
            _loading.value = false
        }
    }
}