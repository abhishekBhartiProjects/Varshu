package abhu.loves.varshu.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil

class WishesCardDataDiffCallback: DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return true
    }
}