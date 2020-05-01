package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily200Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.customModel.Family200
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Family200ViewHolder(
    val context: Context,
    val binding: ItemFamily200Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    val MAX_ITEM = 200

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family200ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily200Binding>(
                inflater,
                R.layout.item_family200,
                viewGroup,
                false
            )
            return Family200ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family200: Family200){
        binding.titleTv.text = family200.title
        binding.horizontalRecyclerview.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        val items: ArrayList<Any> = getItemsWithSeeMore(family200.products)

        val adapter = Family200RecyclerAdapter(items, viewModel)
        binding.horizontalRecyclerview.adapter = adapter
    }

    private fun getItemsWithSeeMore(products: ArrayList<Entry>): ArrayList<Any>{
        val items: ArrayList<Any> = arrayListOf()
        var i: Int = 0
        do {
            items.add(products[i])
            ++i
        } while (products.size > i && i < MAX_ITEM)

        if(products.size > MAX_ITEM && products.size > 0){
            val addMore = SeeMore(products[0])
            items.add(addMore)
        }
        return items
    }
}