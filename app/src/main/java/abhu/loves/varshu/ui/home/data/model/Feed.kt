package abhu.loves.varshu.ui.home.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Feed (
    @SerializedName("entry")
    val entry : ArrayList<Entry>
)