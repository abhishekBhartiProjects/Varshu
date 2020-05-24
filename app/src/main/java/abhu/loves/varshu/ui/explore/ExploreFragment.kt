package abhu.loves.varshu.ui.explore

import abhu.loves.varshu.R
import abhu.loves.varshu.common.Constants
import abhu.loves.varshu.common.RequestResult
import abhu.loves.varshu.ui.home.data.model.Entry
import abhu.loves.varshu.ui.home.data.model.HomeData
import abhu.loves.varshu.utils.ChromeUtils
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import kotlinx.android.synthetic.main.explore_fragment.*


class ExploreFragment : Fragment() {

    var secondaryCategory: String = ""
    lateinit var viewModel: ExploreViewModel

    companion object {
        fun newInstance(bundle: Bundle) = ExploreFragment().apply { arguments = bundle }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            secondaryCategory = arguments?.getString(ExploreActivity.SECONDARY_CATEGORY) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.explore_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initViewModelObserver()
        initViews()
        getExploreData()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, ExploreViewModelFactory()).get(ExploreViewModel::class.java)
    }

    private fun getExploreData() {
        val sheetId = Constants.scMap.get(secondaryCategory)
        sheetId?.let {
            viewModel.getExploreData(sheetId)
        }
    }

    private fun initViewModelObserver() {
        viewModel.getExploreDataMLD.observe(this, Observer {
            it?.let {
                onGetExploreResponse(it)
            }
        })

        viewModel.productClickedMLD.observe(this, Observer {
            it?.let {
                onProductClicked(it)
            }
        })
    }

    private fun initViews() {
        val mLayoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        mLayoutManager.setSpanSizeLookup(object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (recyclerview.adapter!!.getItemViewType(position)) {
                    R.layout.item_title -> 2
                    R.layout.item_product_card3 -> 1
                    else -> 1
                }
            }
        })


        recyclerview.layoutManager = mLayoutManager
    }

    private fun onGetExploreResponse(requestResult: RequestResult<Any>) {
        when (requestResult) {
            is RequestResult.Loading -> {
            }
            is RequestResult.Success -> {
                onGetExploreSuccess(requestResult)
            }
            is RequestResult.Error -> {
            }
        }
    }

    private fun onGetExploreSuccess(success: RequestResult.Success<Any>) {
        if (success.data is HomeData) {
            val items: ArrayList<Entry> = success.data.feed.entry
            initAdapter(items)
        }
    }

    private fun initAdapter(items: ArrayList<Entry>) {
        val adapter = ExploreAdapter(items, viewModel)
        recyclerview.adapter = adapter
    }

    private fun onProductClicked(product: Entry){
        context?.let {
            val chromeUtils = ChromeUtils()
            chromeUtils.openUrlInChrome(context!!, product.deeplink.value)
        }
    }


}