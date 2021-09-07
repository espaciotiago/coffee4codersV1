package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product
import tech.yeswecode.coffee4codersv1.services.NetworkingInterface
import tech.yeswecode.coffee4codersv1.services.NetworkingMockService

class FeedViewModel(service: NetworkingInterface = NetworkingMockService()) {

    private val service: NetworkingInterface = service
    private val _feed = MutableLiveData(ArrayList<ProductViewModel>())
    val feed: LiveData<ArrayList<ProductViewModel>> = _feed

    init {
        loadFeed()
    }

    private fun loadFeed() {
        service.loadFeed { feed, error ->
            if(error != null) {
                //TODO: Handle the error
            } else {
                val feedValues = feed?.map { ProductViewModel(it) }
                _feed.value = feedValues as ArrayList<ProductViewModel>
            }
        }
    }
}