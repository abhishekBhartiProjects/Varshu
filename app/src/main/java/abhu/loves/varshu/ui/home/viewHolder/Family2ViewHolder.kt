package abhu.loves.varshu.ui.home.viewHolder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily2Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.customModel.Family2
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import abhu.loves.varshu.utils.FamilyUtils

class Family2ViewHolder(
    val context: Context,
    val binding: ItemFamily2Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family2ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily2Binding>(
                inflater,
                R.layout.item_family2,
                viewGroup,
                false
            )
            return Family2ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family2: Family2) {
        binding.titleTv.text = family2.title
        binding.card11Cv.visibility = View.GONE
        binding.card12Cv.visibility = View.GONE

        if (family2.products.size > 0) {
            FamilyUtils.bindView(binding.card11Cv, binding.text11Tv, binding.image11Iv, family2.products[0], viewModel)
        }

        if (family2.products.size > 1) {
            FamilyUtils.bindView(binding.card12Cv, binding.text12Tv, binding.image12Iv, family2.products[1], viewModel)
        }
    }

}