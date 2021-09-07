package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.models.Purchase

class CheckoutViewModel(productId: Int) {

    private val emptyProduct = Product(0,"","","",0.0,"","COL")
    private val _productVM = MutableLiveData(ProductViewModel(product = emptyProduct))
    val productVM: LiveData<ProductViewModel> = _productVM

    private val _cities = MutableLiveData(ArrayList<String>())
    val cities: LiveData<ArrayList<String>> = _cities

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _phone = MutableLiveData("")
    val phone: LiveData<String> = _phone

    private val _address = MutableLiveData("")
    val address: LiveData<String> = _address

    private val _city = MutableLiveData("")
    val city: LiveData<String> = _city

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    init {
        getProduct(byId = productId)
    }

    fun setName(name: String) {
        _name.value = name
    }

    fun setEmail(email: String) {
        _email.value = email
    }

    fun setPhone(phone: String) {
        _phone.value = phone
    }

    fun setCity(city: String) {
        _city.value = city
    }

    fun setAddress(address: String) {
        _address.value = address
    }

    private fun getCities(completion: (Boolean) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                _cities.value = Purchase.cities().map { it } as ArrayList<String>
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