package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemCollageBinding
import abhu.loves.varshu.databinding.ItemFooterMessageBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.CollageData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class CollageVH(
    val context: Context,
    val binding: ItemCollageBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): CollageVH {
            val binding = DataBindingUtil.inflate<ItemCollageBinding>(
                inflater,
                R.layout.item_collage,
                viewGroup,
                false
            )
            return CollageVH(context, binding, viewModel)
        }
    }

    fun bind(item: CollageData){

    }
}