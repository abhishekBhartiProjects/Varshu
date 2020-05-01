package abhu.loves.varshu.ui.explore

import abhu.loves.varshu.common.RequestResult
import abhu.loves.varshu.ui.home.model.Entry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class ExploreViewModel : ViewModel() {
    val repo = ExploreRepo()

    var getExploreDataMLD: MutableLiveData<RequestResult<Any>> = MutableLiveData()
    var productClickedMLD: MutableLiveData<Entry> = MutableLiveData()

    fun getExploreData(sheetId: String) {
        viewModelScope.launch {
            getExploreDataMLD.value = RequestResult.Loading("Getting data...")

            try {
                val response = repo.getExploreData(sheetId)
                getExploreDataMLD.value = RequestResult.Success(response)
            } catch (e: Exception) {
                getExploreDataMLD.value = RequestResult.Error(e)
            }
        }
    }

    fun onProductClick(product: Entry){
        productClickedMLD.value = product
    }
}