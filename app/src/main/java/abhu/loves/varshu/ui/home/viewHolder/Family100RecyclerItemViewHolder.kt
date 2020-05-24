package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemProductCardBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.utils.FamilyUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class Family100RecyclerItemViewHolder(
    val context: Context,
    val binding: ItemProductCardBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family100RecyclerItemViewHolder {
            val binding = DataBindingUtil.inflate<ItemProductCardBinding>(
                inflater,
                R.layout.item_product_card,
                viewGroup,
                false
            )
            return Family100RecyclerItemViewHolder(context, binding, viewModel)
        }
    }

    fun bind(product: Entry){
        binding.cardCv.visibility = View.VISIBLE
        binding.textTv.text = product.text.value

        FamilyUtils.bindView(binding.cardCv, binding.textTv, binding.imageIv, product, viewModel)
    }
}