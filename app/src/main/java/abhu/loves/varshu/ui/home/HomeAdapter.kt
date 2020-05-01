package abhu.loves.varshu.ui.home

import abhu.loves.varshu.R
import abhu.loves.varshu.ui.home.model.customModel.*
import abhu.loves.varshu.ui.home.viewHolder.*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class HomeAdapter(var productsList: ArrayList<*>, var viewModel: HomeViewModel):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun getItemViewType(position: Int): Int {
        when(productsList[position]){
            is Family0 ->{}
            is Family1 ->{
                return R.layout.item_family1
            }
            is Family2 ->{
                return R.layout.item_family2
            }
            is Family3 ->{}
            is Family4 ->{
                return R.layout.item_family4
            }
            is Family6 ->{
                return R.layout.item_family6
            }
            is Family100 ->{
                return R.layout.item_family100
            }
            is Family200 ->{
                return R.layout.item_family200
            }
            else -> {
                return R.layout.item_family4
            }
        }
        return R.layout.item_family4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        lateinit var holder: RecyclerView.ViewHolder

        when(viewType){
            R.layout.item_family1 -> {
                holder = Family1ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_family2 -> {
                holder = Family2ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_family4 -> {
                holder = Family4ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_family6 -> {
                holder = Family6ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_family100 -> {
                holder = Family100ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_family200 -> {
                holder = Family200ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
            else -> {
                holder = Family4ViewHolder.create(parent.context, inflater, parent, viewModel)
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is Family1ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family1)
                } catch (e: Exception){

                }
            }
            is Family2ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family2)
                } catch (e: Exception){

                }
            }
            is Family4ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family4)
                } catch (e: Exception){

                }
            }
            is Family6ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family6)
                } catch (e: Exception){

                }
            }
            is Family100ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family100)
                } catch (e: Exception){

                }
            }
            is Family200ViewHolder -> {
                try {
                    holder.bind(productsList[position] as Family200)
                } catch (e: Exception){

                }
            }
        }
    }
}