package abhu.loves.varshu.ui.home.data.model.customModel

import abhu.loves.varshu.ui.home.data.model.Entry
import androidx.annotation.Keep

@Keep
data class Family1 (
    var title: String,
    var products: ArrayList<Entry>
)