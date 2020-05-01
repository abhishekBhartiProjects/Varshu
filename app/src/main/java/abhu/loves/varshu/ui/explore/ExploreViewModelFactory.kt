package abhu.loves.varshu.ui.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExploreViewModelFactory: ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExploreViewModel() as T
    }
}