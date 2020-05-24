package abhu.loves.varshu.ui.navFlow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import abhu.loves.varshu.R
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.product_details_fragment.*
import kotlinx.android.synthetic.main.product_details_fragment.buy_btn


class ProductDetailsFragment : Fragment() {

    lateinit var navController: NavController
    var description: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
        initViews()
        initNavController(view)
        initClickListener()
    }

    private fun initArguments() {
        arguments?.let {
            description = arguments!!.getString("description")
        }
    }

    private fun initViews() {
        product_description_tv.text = description
    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun initClickListener(){
        buy_btn.setOnClickListener {
            val bundle = bundleOf(
                "description" to description,
                "cost" to Money(30)
            )
            navController.navigate(R.id.action_productDetailsFragment_to_productCheckoutFragment2, bundle)
        }
    }

}
