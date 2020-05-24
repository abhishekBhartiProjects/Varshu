package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemWishcardBinding
import abhu.loves.varshu.databinding.ItemWishcardChildItemBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.Card
import abhu.loves.varshu.utils.FamilyUtils
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

class WishesCardItemVH (
    val context: Context,
    val binding: ItemWishcardChildItemBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val LAYOUT = R.layout.item_wishcard_child_item
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): WishesCardItemVH {
            val binding = DataBindingUtil.inflate<ItemWishcardChildItemBinding>(
                inflater,
                LAYOUT,
                viewGroup,
                false
            )
            return WishesCardItemVH(context, binding, viewModel)
        }
    }

    fun bind(card: Card){
//        binding.imgIv.layout(0,0,0,0)
        val options: RequestOptions = RequestOptions()
            .fallback(R.drawable.img_default)
            .error(R.drawable.img_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        Glide.with(binding.root.context)
            .load(Uri.parse(card.imageUrl))
            .apply(options)
            .into(binding.imgIv)
    }
}