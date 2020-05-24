package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemFamily100Binding
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.ui.home.data.model.customModel.Family100
import abhu.loves.varshu.ui.home.data.model.customModel.SeeMore
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Family100ViewHolder(
    val context: Context,
    val binding: ItemFamily100Binding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    val MAX_ITEM = 6

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): Family100ViewHolder {
            val binding = DataBindingUtil.inflate<ItemFamily100Binding>(
                inflater,
                R.layout.item_family100,
                viewGroup,
                false
            )
            return Family100ViewHolder(context, binding, viewModel)
        }
    }

    fun bind(family100: Family100){
        binding.titleTv.text = family100.title
        binding.horizontalRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val items: ArrayList<Any> = getItemsWithSeeMore(family100.products)

        val adapter = Family100RecyclerAdapter(items, viewModel)
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