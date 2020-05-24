package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemHeadingBinding
import abhu.loves.varshu.databinding.ItemLoveMessageBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.WishesCardData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class HeadingVH(
    val context: Context,
    val binding: ItemHeadingBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): HeadingVH {
            val binding = DataBindingUtil.inflate<ItemHeadingBinding>(
                inflater,
                R.layout.item_heading,
                viewGroup,
                false
            )
            return HeadingVH(context, binding, viewModel)
        }
    }

    fun bind(item: String){
        binding.headingTv.visibility = View.VISIBLE
        binding.headingTv.text = item
    }
}