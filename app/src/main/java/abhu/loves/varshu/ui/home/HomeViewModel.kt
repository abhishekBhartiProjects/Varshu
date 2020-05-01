package abhu.loves.varshu.ui.home

import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(application: Application): AndroidViewModel(application) {
    val homeRepo = HomeRepo()
    var homeDataMLD: MutableLiveData<Any> = MutableLiveData()
    var productClickedMLD: MutableLiveData<Entry> = MutableLiveData()
    var seeMoreClickedMLD: MutableLiveData<SeeMore> = MutableLiveData()

    fun getData(){
        homeRepo.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onGetDataSuccess(it)
            }, {
                onGetDataError(it)
            })
    }

    private fun onGetDataSuccess(any: Any){
        homeDataMLD.value = any
    }

    private fun onGetDataError(throwable: Throwable){
        homeDataMLD.value = throwable
    }

    fun onProductClick(product: Entry){
        productClickedMLD.value = product
    }

    fun onAddMoreClicked(seeMore: SeeMore){
        seeMoreClickedMLD.value = seeMore
    }
}