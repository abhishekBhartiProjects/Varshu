package abhu.loves.varshu.ui.explore.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemTitleBinding
import abhu.loves.varshu.ui.explore.ExploreViewModel
import abhu.loves.varshu.ui.home.data.model.Entry
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class ExploreTitleViewHolder(
    val context: Context,
    val binding: ItemTitleBinding,
    val viewModel: ExploreViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: ExploreViewModel
        ): ExploreTitleViewHolder {
            val binding = DataBindingUtil.inflate<ItemTitleBinding>(
                inflater,
                R.layout.item_title,
                viewGroup,
                false
            )
            return ExploreTitleViewHolder(
                context,
                binding,
                viewModel
            )
        }
    }

    fun bind(entry: Entry){
        binding.titleTv.text = entry.text.value ?: ""
    }
}