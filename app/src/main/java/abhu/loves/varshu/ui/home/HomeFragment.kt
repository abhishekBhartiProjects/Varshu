package abhu.loves.varshu.ui.home

import abhu.loves.varshu.AppApplication
import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.HomeFragmentBinding
import abhu.loves.varshu.ui.explore.ExploreActivity
import abhu.loves.varshu.ui.home.model.Entry
import abhu.loves.varshu.ui.home.model.customModel.SeeMore
import abhu.loves.varshu.utils.ChromeUtils
import android.app.Application
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment: Fragment() {

    lateinit var viewModel: HomeViewModel
    companion object{
        val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<HomeFragmentBinding>(LayoutInflater.from(context), R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        initViewModelObserver()
        initViews()

        getData()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this, HomeViewModelFactory(AppApplication())).get(HomeViewModel::class.java)
    }

    private fun initViewModelObserver(){
        viewModel.homeDataMLD.observe(this, Observer {
            it?.let {
                when(it){
                    is ArrayList<*> -> { onHomeDataResponse(it as ArrayList<Any>)}
                    is Throwable -> { onHomeDataError(it)}
                    else -> {}
                }
            }
        })

        viewModel.productClickedMLD.observe(this, Observer {
            it?.let {
                onProductClicked(it)
            }
        })

        viewModel.seeMoreClickedMLD.observe(this, Observer {
            it?.let {
                onSeeMoreClicked(it)
            }
        })
    }

    private fun onHomeDataResponse(productMap: ArrayList<Any>){
        setAdapter(productMap)
    }

    private fun onHomeDataError(throwable: Throwable){

    }

    private fun initViews(){
        load_btn.setOnClickListener { getData() }
    }

    private fun setAdapter(productList: ArrayList<*>){
        recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adpter = HomeAdapter(productList, viewModel)
        recyclerview.adapter = adpter
    }

    private fun getData(){
        viewModel.getData()
    }

    private fun onProductClicked(product: Entry){
        context?.let {
            val chromeUtils = ChromeUtils()
            chromeUtils.openUrlInChrome(context!!, product.deeplink.value)
        }
    }

    private fun onSeeMoreClicked(seeMore: SeeMore){
        context?.let {
            val exploreStartParam = ExploreActivity.ExploreActivityStartParams(seeMore.product.secondaryCategory.value ?: "")
            ExploreActivity.start(context!!, exploreStartParam)
        }
    }

}