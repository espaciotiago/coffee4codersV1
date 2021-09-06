package tech.yeswecode.coffee4codersv1.viewModels

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tech.yeswecode.coffee4codersv1.models.Product

class FeedViewModel {

    private val _feed = MutableLiveData(ArrayList<ProductViewModel>())
    val feed: LiveData<ArrayList<ProductViewModel>> = _feed

    init {
        loadFeed()
    }

    private fun loadFeed() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val feedMock = Product.list().map { ProductViewModel(it) }
                _feed.value = feedMock as ArrayList<ProductViewModel>
            },
            5000
        )
    }
}