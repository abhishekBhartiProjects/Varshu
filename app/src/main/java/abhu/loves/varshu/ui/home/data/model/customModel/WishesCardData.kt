package abhu.loves.varshu.ui.home.data.model.customModel

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
data class WishesCardData(
    val cards: ArrayList<Card>
) {
}

@Keep
@Parcelize
data class Card(
    val imageUrl: String,
    val msg: String
): Parcelable{}