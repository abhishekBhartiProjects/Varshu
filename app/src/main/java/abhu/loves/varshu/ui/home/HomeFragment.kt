package abhu.loves.varshu.ui.home

import abhu.loves.varshu.AppApplication
import abhu.loves.varshu.R
import abhu.loves.varshu.databinding.HomeFragmentBinding
import abhu.loves.varshu.ui.explore.ExploreActivity
import abhu.loves.varshu.ui.home.adapter.HomeAdapter
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.ui.home.data.model.customModel.SeeMore
import abhu.loves.varshu.ui.navFlow.ProductActivity
import abhu.loves.varshu.utils.ChromeUtils
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
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
        viewModel.homeDataMLD.observe(viewLifecycleOwner, Observer {
            it?.let {
                when(it){
                    is ArrayList<*> -> { onHomeDataResponse(it as ArrayList<Any>)}
                    is Throwable -> { onHomeDataError(it)}
                    else -> {}
                }
            }
        })

        viewModel.productClickedMLD.observe(viewLifecycleOwner, Observer {
            it?.let {
                onProductClicked(it)
            }
        })

        viewModel.seeMoreClickedMLD.observe(viewLifecycleOwner, Observer {
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
        load_btn.setOnClickListener { scheduleWork() }
        nav_btn.setOnClickListener {
            startActivity(Intent(requireContext(), ProductActivity::class.java))
        }
    }

    private fun scheduleWork() {
        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val inputData = Data.Builder()
            .putString("inputData", "This is input data")
            .build()

        val workRequest = OneTimeWorkRequest.Builder(HomeWork::class.java)
            .setConstraints(constraint)
            .setInputData(inputData)
            .build()
        WorkManager.getInstance(requireContext()).enqueue(workRequest)

        initWorkManagerObserver(workRequest)
    }

    private fun initWorkManagerObserver(workRequest: OneTimeWorkRequest) {
        WorkManager.getInstance(requireContext()).getWorkInfoByIdLiveData(workRequest.id).observe(viewLifecycleOwner, Observer {
           if(it.state == WorkInfo.State.SUCCEEDED){
               val outputData = it.outputData
               Log.e("Worker OutputData: ", outputData.getString("outputData") ?: "")
           }
        })
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
            chromeUtils.openUrlInChrome(requireContext(), product.deeplink.value)
        }
    }

    private fun onSeeMoreClicked(seeMore: SeeMore){
        context?.let {
            val exploreStartParam = ExploreActivity.ExploreActivityStartParams(seeMore.product.secondaryCategory.value ?: "")
            ExploreActivity.start(requireContext(), exploreStartParam)
        }
    }

}