package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemMywishcardBinding
import abhu.loves.varshu.ui.home.HomeViewModel
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

class MyWishCardVH (
    val context: Context,
    val binding: ItemMywishcardBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): MyWishCardVH {
            val binding = DataBindingUtil.inflate<ItemMywishcardBinding>(
                inflater,
                R.layout.item_mywishcard,
                viewGroup,
                false
            )
            return MyWishCardVH(context, binding, viewModel)
        }
    }

    fun bind(item: MyWishCardData){
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