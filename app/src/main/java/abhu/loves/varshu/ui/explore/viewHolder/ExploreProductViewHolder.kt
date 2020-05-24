package abhu.loves.varshu.ui.explore.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemProductCard2Binding
import abhu.loves.varshu.ui.explore.ExploreViewModel
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.utils.ViewUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class ExploreProductViewHolder(
    val context: Context,
    val binding: ItemProductCard2Binding,
    val viewModel: ExploreViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: ExploreViewModel
        ): ExploreProductViewHolder {
            val binding = DataBindingUtil.inflate<ItemProductCard2Binding>(
                inflater,
                R.layout.item_product_card2,
                viewGroup,
                false
            )
            return ExploreProductViewHolder(
                context,
                binding,
                viewModel
            )
        }
    }

    fun bind(product: Entry, position: Int){

        val options = RequestOptions()
            .fallback(R.drawable.img_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        var color: Int = R.color.green_86bf95_20
        when(position % 4){
            0 -> { color = R.color.green_86bf95_20 }
            1 -> { color = R.color.red_cc8b93_20 }
            2 -> { color = R.color.blue_8ba4cc_20 }
            3 -> { color = R.color.yello_a89668_20 }
        }
        ViewUtils.changeDrawableColor(context, binding.containerCl.background, color)
        binding.textTv.text = product.text.value
        Glide.with(context)
            .load(product.image.value)
            .apply(options)
            .into(binding.imageIv)

        binding.containerCl.setOnClickListener {
            viewModel.onProductClick(product)
        }
    }
}