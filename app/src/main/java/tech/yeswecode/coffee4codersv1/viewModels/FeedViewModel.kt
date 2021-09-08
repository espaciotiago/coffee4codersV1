package tech.yeswecode.coffee4codersv1.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.services.NetworkingInterface
import tech.yeswecode.coffee4codersv1.services.NetworkingMockService

class FeedViewModel(service: NetworkingInterface = NetworkingMockService()) {

    private val service: NetworkingInterface = service

    private val _feed = MutableLiveData(ArrayList<ProductViewModel>())
    val feed: LiveData<ArrayList<ProductViewModel>> = _feed

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    init {
        loadFeed()
    }

    fun loadFeed() {
        _loading.value = true
        service.loadFeed { feed, error ->
            if(error != null) {
                _errorMessage.value = error
            } else {
                val feedValues = feed?.map { ProductViewModel(it) }
                _feed.value = feedValues as ArrayList<ProductViewModel>
            }
            _loading.value = false
        }
    }
}