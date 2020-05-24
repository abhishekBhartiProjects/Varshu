package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemLoveMessageBinding
import abhu.loves.varshu.databinding.ItemMomentsVideoBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.LoveMessage
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class LoveMsgVH(
    val context: Context,
    val binding: ItemLoveMessageBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): LoveMsgVH {
            val binding = DataBindingUtil.inflate<ItemLoveMessageBinding>(
                inflater,
                R.layout.item_love_message,
                viewGroup,
                false
            )
            return LoveMsgVH(context, binding, viewModel)
        }
    }

    fun bind(item: LoveMessage){

    }
}