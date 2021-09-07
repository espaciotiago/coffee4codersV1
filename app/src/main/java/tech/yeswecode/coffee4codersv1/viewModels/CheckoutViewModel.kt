package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product

private fun cities(): List<String> {
    return listOf(
        "Ciudad de México, México",
        "La Habana, Cuba",
        "Cancún, México",
        "Medellín, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Perú",
        "Montevideo, Uruguay",
        "Ciudad de Panamá, Panamá"
    )
}

class CheckoutViewModel(productId: Int) {

    private val emptyProduct = Product(0,"","","",0.0,"","COL")
    private val _productVM = MutableLiveData(ProductViewModel(product = emptyProduct))
    val productVM: LiveData<ProductViewModel> = _productVM

    private val _cities = MutableLiveData(ArrayList<String>())
    val cities: LiveData<ArrayList<String>> = _cities

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    init {
        getProduct(byId = productId)
    }

    private fun getCities(completion: (Boolean) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                _cities.value = cities().map { it } as ArrayList<String>
                completion(true)
            }, 500)
    }

    private fun getProduct(byId: Int) {
        _loading.value = true
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val productSelected = Product.list().find { it.id == byId }
                _productVM.value = productSelected?.let { ProductViewModel(product = it) }
                getCities {
                    if(it) {
                        _loading.value = false
                    }
                }
            }, 500)
    }
}