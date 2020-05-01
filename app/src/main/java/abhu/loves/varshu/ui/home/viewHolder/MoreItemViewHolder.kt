package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemMoreBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import abhu.loves.varshu.utils.ViewUtils

class MoreItemViewHolder (
    val context: Context,
    val binding: ItemMoreBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): MoreItemViewHolder {
            val binding = DataBindingUtil.inflate<ItemMoreBinding>(
                inflater,
                R.layout.item_more,
                viewGroup,
                false
            )
            return MoreItemViewHolder(context, binding, viewModel)
        }
    }

    fun bind(seeMore: SeeMore){

        ViewUtils.changeDrawableColor(context, binding.containerAddMoreCl.background, R.color.orange_ffc099)

        binding.containerAddMoreCl.setOnClickListener {
            viewModel.onAddMoreClicked(seeMore)
        }
    }
}