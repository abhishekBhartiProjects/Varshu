package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily4Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.customModel.Family4
import abhu.loves.varshu.utils.FamilyUtils
import abhu.loves.varshu.utils.ViewUtils
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class Family4ViewHolder(
    val context: Context,
    val binding: ItemFamily4Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family4ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily4Binding>(
                inflater,
                R.layout.item_family4,
                viewGroup,
                false
            )
            return Family4ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family4: Family4){
        binding.titleTv.text = family4.title

        ViewUtils.changeDrawableColor(context, binding.include11.containerCl.background, R.color.green_86bf95_20)
        ViewUtils.changeDrawableColor(context, binding.include12.containerCl.background, R.color.red_cc8b93_20)
        ViewUtils.changeDrawableColor(context, binding.include21.containerCl.background, R.color.blue_8ba4cc_20)
        ViewUtils.changeDrawableColor(context, binding.include22.containerCl.background, R.color.yello_a89668_20)

        FamilyUtils.bindView(binding.include11.containerCl, binding.include11.textTv, binding.include11.imageIv, family4.products[0], viewModel)
        FamilyUtils.bindView(binding.include12.containerCl, binding.include12.textTv, binding.include12.imageIv, family4.products[1], viewModel)
        FamilyUtils.bindView(binding.include21.containerCl, binding.include21.textTv, binding.include21.imageIv, family4.products[2], viewModel)
        FamilyUtils.bindView(binding.include22.containerCl, binding.include22.textTv, binding.include22.imageIv, family4.products[3], viewModel)

    }
}