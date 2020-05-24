package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemTogetherPicsBinding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.TogetherPicsData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class TogetherPicsVH(
    val context: Context,
    val binding: ItemTogetherPicsBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): TogetherPicsVH {
            val binding = DataBindingUtil.inflate<ItemTogetherPicsBinding>(
                inflater,
                R.layout.item_together_pics,
                viewGroup,
                false
            )
            return TogetherPicsVH(context, binding, viewModel)
        }
    }

    fun bind(item: TogetherPicsData){

    }
}