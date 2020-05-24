package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemMomentsVideoBinding
import abhu.loves.varshu.databinding.ItemTogetherPicsBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.MomentsVideo
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class MomentsVideoVH(
    val context: Context,
    val binding: ItemMomentsVideoBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): MomentsVideoVH {
            val binding = DataBindingUtil.inflate<ItemMomentsVideoBinding>(
                inflater,
                R.layout.item_moments_video,
                viewGroup,
                false
            )
            return MomentsVideoVH(context, binding, viewModel)
        }
    }

    fun bind(item: MomentsVideo){
// todo
    }
}