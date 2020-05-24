package abhu.loves.varshu.ui.home.viewHolder

import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.ItemWishcardBinding
import abhu.loves.varshu.ui.home.HomeActivity
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.WishCardFragment
import abhu.loves.varshu.ui.home.adapter.PagerAdapter
import abhu.loves.varshu.ui.home.adapter.WishesCardAdapter
import abhu.loves.varshu.ui.home.data.model.customModel.WishesCardData
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.DimenRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

class WishesCardVH(
    val context: Context,
    val binding: ItemWishcardBinding,
    val viewModel: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {

    internal var handler: Handler? = null
    internal var runnable: Runnable? = null

    companion object {
        fun create(
            context: Context,
            inflater: LayoutInflater,
            viewGroup: ViewGroup,
            viewModel: HomeViewModel
        ): WishesCardVH {
            val binding = DataBindingUtil.inflate<ItemWishcardBinding>(
                inflater,
                R.layout.item_wishcard,
                viewGroup,
                false
            )
            return WishesCardVH(context, binding, viewModel)
        }
    }

    fun bind(item: WishesCardData) {
        setViewPager(item)
        submitList(item.cards as ArrayList<Any>)
    }

    lateinit var adapter: WishesCardAdapter
    private fun setViewPager(item: WishesCardData) {

        binding.wishesViewPager.clipToPadding = false
        binding.wishesViewPager.setPadding(60,0,60, 0)
        binding.wishesViewPager.pageMargin = 20
        binding.wishesViewPager.offscreenPageLimit = item.cards.size

        binding.wishesViewPager.adapter = PagerAdapter((binding.root.context as HomeActivity).supportFragmentManager, getFragments(item), getTitles(item))

        val cardCount = item.cards.size
        autoScrollViewPager(cardCount)

        val circlePageIndicators = arrayOfNulls<View>(cardCount)
        binding.circleIndicatorLl.removeAllViews()
        for (i in 0 until cardCount) {
            circlePageIndicators[i] = (binding.root.context as HomeActivity).layoutInflater.inflate(R.layout.circle_indicator, null)
            binding.circleIndicatorLl.addView(circlePageIndicators[i], i)
        }
        if(circlePageIndicators != null && circlePageIndicators.size > 0){
            circlePageIndicators[0]!!.setAlpha(1f)
        }

        binding.wishesViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            internal var prevPos: Int = 0
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (handler != null && runnable != null) {
                    handler!!.removeCallbacks(runnable)
                }

                if(circlePageIndicators.size > prevPos && circlePageIndicators.size > position) {
                    circlePageIndicators[prevPos]!!.setAlpha(0.2f)
                    circlePageIndicators[position]!!.setAlpha(1f)
                    prevPos = position
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun autoScrollViewPager(cardCount: Int) {
        if(handler == null){
            val duration = 4000
            handler = Handler()

            runnable = object : Runnable {
                override fun run() {
                    try {
                        if (binding.wishesViewPager != null) {
                            if (binding.wishesViewPager.currentItem == cardCount - 1) {
                                binding.wishesViewPager.setCurrentItem(0, true)
                            } else {
                                binding.wishesViewPager.setCurrentItem(binding.wishesViewPager.currentItem + 1, true)
                            }
                            handler!!.postDelayed(this, duration.toLong())
                        }
                    } catch (e: ArrayIndexOutOfBoundsException) {

                    }

                }
            }

            handler!!.postDelayed(runnable, duration.toLong())
        }
    }

    private fun getFragments(item: WishesCardData): ArrayList<Fragment>{
        val fragments = arrayListOf<Fragment>()
        for(card in item.cards) {
            val bundle = Bundle()
            bundle.putParcelable("card", card)
            val fragment = WishCardFragment.newInstance(bundle)
            fragments.add(fragment)
        }

        return fragments
    }

    private fun getTitles(item: WishesCardData): ArrayList<String>{
        val titles = arrayListOf<String>()
        for(card in item.cards) {
            titles.add("")
        }

        return titles
    }

    private fun submitList(items: ArrayList<Any>) {
        if(::adapter.isInitialized){
            adapter.submitList(items)
        }
    }

}