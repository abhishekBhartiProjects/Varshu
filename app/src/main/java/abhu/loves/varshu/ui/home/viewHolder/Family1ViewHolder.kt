package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily1Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.Family1
import abhu.loves.varshu.utils.FamilyUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class Family1ViewHolder (
    val context: Context,
    val binding: ItemFamily1Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family1ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily1Binding>(
                inflater,
                R.layout.item_family1,
                viewGroup,
                false
            )
            return Family1ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family1: Family1){
        binding.titleTv.text = family1.title

        binding.image11Iv.layout(0,0,0,0)
        FamilyUtils.bindView(binding.containerCl, binding.text11Tv, binding.image11Iv, family1.products[0], viewModel)
    }
}