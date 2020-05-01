package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily6Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.customModel.Family6
import abhu.loves.varshu.utils.FamilyUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class Family6ViewHolder (
    val context: Context,
    val binding: ItemFamily6Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family6ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily6Binding>(
                inflater,
                R.layout.item_family6,
                viewGroup,
                false
            )
            return Family6ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family6: Family6){
        binding.titleTv.text = family6.title
        binding.card11Cv.visibility = View.GONE
        binding.card12Cv.visibility = View.GONE
        binding.card21Cv.visibility = View.GONE
        binding.card22Cv.visibility = View.GONE
        binding.card31Cv.visibility = View.GONE
        binding.card32Cv.visibility = View.GONE

        if(family6.products.size > 0){
            FamilyUtils.bindView(binding.card11Cv, binding.text11Tv, binding.image11Iv, family6.products[0], viewModel)
        }

        if(family6.products.size > 1){
            FamilyUtils.bindView(binding.card12Cv, binding.text12Tv, binding.image12Iv, family6.products[1], viewModel)
        }

        if(family6.products.size > 2){
            FamilyUtils.bindView(binding.card21Cv, binding.text21Tv, binding.image21Iv, family6.products[2], viewModel)
        }

        if(family6.products.size > 3){
            FamilyUtils.bindView(binding.card22Cv, binding.text22Tv, binding.image22Iv, family6.products[3], viewModel)
        }

        if(family6.products.size > 4){
            FamilyUtils.bindView(binding.card31Cv, binding.text31Tv, binding.image31Iv, family6.products[4], viewModel)
        }

        if(family6.products.size > 5){
            FamilyUtils.bindView(binding.card32Cv, binding.text32Tv, binding.image32Iv, family6.products[5], viewModel)
        }

    }
}