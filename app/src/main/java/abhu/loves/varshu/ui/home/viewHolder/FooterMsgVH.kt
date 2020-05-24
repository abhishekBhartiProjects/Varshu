package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFooterMessageBinding
import abhu.loves.varshu.databinding.ItemFriendsWishcardBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.FooterMessage
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class FooterMsgVH(
    val context: Context,
    val binding: ItemFooterMessageBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): FooterMsgVH {
            val binding = DataBindingUtil.inflate<ItemFooterMessageBinding>(
                inflater,
                R.layout.item_footer_message,
                viewGroup,
                false
            )
            return FooterMsgVH(context, binding, viewModel)
        }
    }

    fun bind(item: FooterMessage){

    }
}