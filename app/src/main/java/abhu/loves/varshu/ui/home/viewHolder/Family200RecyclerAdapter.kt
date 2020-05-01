package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Family200RecyclerAdapter(
    var items: ArrayList<Any>,
    var viewModel: HomeViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        when (items[position]) {
            is Entry -> {
                return R.layout.item_product_card3
            }
            else -> {
                return R.layout.item_more
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        lateinit var holder: RecyclerView.ViewHolder

        when (viewType) {
            R.layout.item_product_card3 -> {
                holder = Family200RecyclerItemViewHolder.create(
                    parent.context,
                    inflater,
                    parent,
                    viewModel
                )
            }

            else -> {
                holder = MoreItemViewHolder.create(parent.context, inflater, parent, viewModel)
            }
        }

        return holder
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is Family200RecyclerItemViewHolder -> {
                holder.bind(items[position] as Entry, position)
            }
            is MoreItemViewHolder -> {
                holder.bind(items[position] as SeeMore)
            }
        }
    }
}