package abhu.loves.varshu.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(val fm: FragmentManager,
                   val fragments : List<Fragment>,
                   val titles : List<String>) : FragmentPagerAdapter(fm) {



    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles.get(position)
    }

}