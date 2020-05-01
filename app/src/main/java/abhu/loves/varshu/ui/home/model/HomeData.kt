package abhu.loves.varshu.ui.home.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HomeData (
    @SerializedName("feed")
    val feed: Feed,
    @SerializedName("Meta Data")
    val metadata: Metadata
)

data class Metadata (
    @SerializedName("1. Information")
    val information: String
)

