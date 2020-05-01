package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemProductCard3Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.utils.FamilyUtils
import abhu.loves.varshu.utils.ViewUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class Family200RecyclerItemViewHolder(
    val context: Context,
    val binding: ItemProductCard3Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family200RecyclerItemViewHolder {
            val binding = DataBindingUtil.inflate<ItemProductCard3Binding>(
                inflater,
                R.layout.item_product_card3,
                viewGroup,
                false
            )
            return Family200RecyclerItemViewHolder(context, binding, viewModel)
        }
    }

    fun bind(product: Entry, position: Int){
        var color: Int = R.color.green_86bf95_20
        when(position % 4){
            0 -> { color = R.color.green_86bf95_20 }
            1 -> { color = R.color.red_cc8b93_20 }
            2 -> { color = R.color.blue_8ba4cc_20 }
            3 -> { color = R.color.yello_a89668_20 }
        }
        ViewUtils.changeDrawableColor(context, binding.containerCl.background, color)

        FamilyUtils.bindView(binding.containerCl, binding.textTv, binding.imageIv, product, viewModel)
    }
}