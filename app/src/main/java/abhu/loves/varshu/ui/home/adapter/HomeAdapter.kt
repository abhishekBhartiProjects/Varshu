package abhu.loves.varshu.ui.home.adapter

import abhu.loves.varshu.R
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.customModel.*
import abhu.loves.varshu.ui.home.viewHolder.*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(var itemList: ArrayList<*>, var viewModel: HomeViewModel):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        when(itemList[position]){
            is WishesCardData -> {return R.layout.item_wishcard}
            is String -> {return R.layout.item_heading}
            is MyWishCardData -> {return R.layout.item_mywishcard}
            is FriendsWishCardData -> {return R.layout.item_friends_wishcard}
            is TogetherPicsData -> {return R.layout.item_together_pics}
            is MomentsVideo -> {return R.layout.item_moments_video}
            is CollageData -> {return R.layout.item_collage}
            is LoveMessage -> {return R.layout.item_love_message}
            is FooterMessage -> {return R.layout.item_footer_message}
            else -> {return R.layout.item_heading}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        lateinit var holder: RecyclerView.ViewHolder

        when(viewType){
            R.layout.item_wishcard -> {
                holder = WishesCardVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_heading -> {
                holder = HeadingVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_mywishcard -> {
                holder = MyWishCardVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_friends_wishcard -> {
                holder = FriendsWishCardVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_together_pics -> {
                holder = TogetherPicsVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_moments_video -> {
                holder = MomentsVideoVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_collage -> {
                holder = CollageVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_love_message -> {
                holder = LoveMsgVH.create(parent.context, inflater, parent, viewModel)
            }
            R.layout.item_footer_message -> {
                holder = FooterMsgVH.create(parent.context, inflater, parent, viewModel)
            }
            else -> {
                holder = HeadingVH.create(parent.context, inflater, parent, viewModel)
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is WishesCardVH -> {
                holder.bind(itemList[position] as WishesCardData)
            }
            is HeadingVH -> {
                holder.bind(itemList[position] as String)
            }
            is MyWishCardVH -> {
                holder.bind(itemList[position] as MyWishCardData)
            }
            is FriendsWishCardVH -> {
                holder.bind(itemList[position] as FriendsWishCardData)
            }
            is TogetherPicsVH -> {
                holder.bind(itemList[position] as TogetherPicsData)
            }
            is MomentsVideoVH -> {
                holder.bind(itemList[position] as MomentsVideo)
            }
            is CollageVH -> {
                holder.bind(itemList[position] as CollageData)
            }
            is LoveMsgVH -> {
                holder.bind(itemList[position] as LoveMessage)
            }
            is FooterMsgVH -> {
                holder.bind(itemList[position] as FooterMessage)
            }
        }
    }
}