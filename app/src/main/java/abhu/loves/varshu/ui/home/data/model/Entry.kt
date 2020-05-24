package abhu.loves.varshu.ui.home.data.model

import abhu.loves.varshu.common.Constants
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class Entry (
    @SerializedName("gsx\$groupid")
    val groupId: GroupId,
    @SerializedName("gsx\$family")
    val family: Family,
    @SerializedName("gsx\$type")
    val type: Type,
    @SerializedName("gsx\$primarycategory")
    val primaryCategory: PrimaryCategory,
    @SerializedName("gsx\$secondarycategory")
    val secondaryCategory: SecondaryCategory,
    @SerializedName("gsx\$image")
    val image: Image,
    @SerializedName("gsx\$text")
    val text: Text,
    @SerializedName("gsx\$deeplink")
    val deeplink: Deeplink

):Parcelable

@Parcelize
data class GroupId(
    @SerializedName("\$t")
    var value: String? = ""
):Parcelable

@Parcelize
data class Family(
    @SerializedName("\$t")
    var value: Int = -1
):Parcelable

@Parcelize
data class Type(
    @SerializedName("\$t")
    var value: String = ""
):Parcelable

@Parcelize
data class PrimaryCategory(
    @SerializedName("\$t")
    var value: String? = ""
):Parcelable

@Parcelize
data class SecondaryCategory(
    @SerializedName("\$t")
    var value: String? = ""
):Parcelable

@Parcelize
data class Image(
    @SerializedName("\$t")
    var value: String? = ""
):Parcelable

@Parcelize
data class Text(
    @SerializedName("\$t")
    var value: String? = ""
):Parcelable

@Parcelize
data class Deeplink(
    @SerializedName("\$t")
    var value: String? = Constants.AMAZON_HOMEPAGE
):Parcelable