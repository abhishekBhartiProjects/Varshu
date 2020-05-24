package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFriendsWishcardBinding
import abhu.loves.varshu.databinding.ItemHeadingBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.FriendsWishCardData
import abhu.loves.varshu.ui.home.data.model.customModel.MyWishCardData
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class FriendsWishCardVH(
    val context: Context,
    val binding: ItemFriendsWishcardBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): FriendsWishCardVH {
            val binding = DataBindingUtil.inflate<ItemFriendsWishcardBinding>(
                inflater,
                R.layout.item_friends_wishcard,
                viewGroup,
                false
            )
            return FriendsWishCardVH(context, binding, viewModel)
        }
    }

    fun bind(item: FriendsWishCardData){
        val options: RequestOptions = RequestOptions()
            .fallback(R.drawable.img_default)
            .error(R.drawable.img_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        Glide.with(binding.root.context)
            .load(Uri.parse(item.wishImage))
            .apply(options)
            .into(binding.imgIv)
    }
}