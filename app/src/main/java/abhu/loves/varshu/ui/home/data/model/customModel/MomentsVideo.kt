package abhu.loves.varshu.ui.home.data.model.customModel

import androidx.annotation.Keep

@Keep
data class MomentsVideo(
    val videoId: String,
    val videoUrl: String,
    val videoName: String,
    val videoThumbnail: String
) {
}