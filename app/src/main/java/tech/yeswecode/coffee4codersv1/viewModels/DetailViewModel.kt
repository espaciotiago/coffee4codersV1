package tech.yeswecode.coffee4codersv1.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.services.NetworkingInterface
import tech.yeswecode.coffee4codersv1.services.NetworkingMockService

class DetailViewModel(productId: Int, service: NetworkingInterface = NetworkingMockService()) {

    private val service: NetworkingInterface = service

    private var productId = productId

    private val emptyProduct = Product(0,"","","",0.0,"","COL")
    private val _productVM = MutableLiveData(ProductViewModel(product = emptyProduct))
    val productVM: LiveData<ProductViewModel> = _productVM

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage

    init {
        getProduct()
    }

    fun getProduct() {
        _loading.value = true
        service.getProduct(productId) { product, error ->
            if (error != null) {
                _errorMessage.value = error
            } else {
                _productVM.value = product?.let { ProductViewModel(product = it) }
            }
            _loading.value = false
        }
    }
}