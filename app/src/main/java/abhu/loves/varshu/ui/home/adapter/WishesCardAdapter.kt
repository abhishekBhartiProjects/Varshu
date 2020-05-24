package abhu.loves.varshu.ui.home.adapter

import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.Card
import abhu.loves.varshu.ui.home.data.model.customModel.WishesCardData
import abhu.loves.varshu.ui.home.viewHolder.WishesCardItemVH
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class WishesCardAdapter(val viewModel: HomeViewModel): ListAdapter<Any, RecyclerView.ViewHolder>(WishesCardDataDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        when(getItem(position)) {
            is Card -> return WishesCardItemVH.LAYOUT
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)
        when(viewType) {
            WishesCardItemVH.LAYOUT -> viewHolder = WishesCardItemVH.create(parent.context, inflater, parent, viewModel)
        }
        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when(holder){
            is WishesCardItemVH -> holder.bind(item as Card)
        }
    }
}