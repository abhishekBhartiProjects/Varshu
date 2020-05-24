package abhu.loves.varshu.ui.explore

import abhu.loves.varshu.R
import abhu.loves.varshu.common.Constants
import abhu.loves.varshu.ui.explore.viewHolder.ExploreProductViewHolder
import abhu.loves.varshu.ui.explore.viewHolder.ExploreTitleViewHolder
import abhu.loves.varshu.ui.home.data.model.Entry
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ExploreAdapter(val items: ArrayList<Entry>, val viewModel: ExploreViewModel): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        when(items[position].type.value){
            Constants.TYPE_TITLE -> { return R.layout.item_title }
            else -> { return R.layout.item_product_card2 }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        lateinit var holder: RecyclerView.ViewHolder

        when(viewType){
            R.layout.item_title -> {
                holder = ExploreTitleViewHolder.create(
                    parent.context,
                    inflater,
                    parent,
                    viewModel
                )
            }
            else -> {
                holder = ExploreProductViewHolder.create(
                    parent.context,
                    inflater,
                    parent,
                    viewModel
                )
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ExploreProductViewHolder -> {
                holder.bind(items[position] as Entry, position)
            }
            is ExploreTitleViewHolder -> {
                holder.bind(items[position] as Entry)
            }
        }
    }
}