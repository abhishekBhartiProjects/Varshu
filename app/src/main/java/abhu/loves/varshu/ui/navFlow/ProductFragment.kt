package abhu.loves.varshu.ui.navFlow

import abhu.loves.varshu.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.product_fragment.*

class ProductFragment: Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.product_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNavController(view)
        initClickListeners()
    }

    private fun initNavController(view: View) {
//        navController = Navigation.findNavController(view)
//        navController = view.findNavController()
//        navController = findNavController(this)
        navController = findNavController()
    }

    private fun initClickListeners() {
        details_btn.setOnClickListener {
//            val bundle = bundleOf("description" to getString(R.string.dummy_text))
//            navController.navigate(R.id.action_productFragment_to_productDetailsFragment, bundle)

            val directions = ProductFragmentDirections.actionProductFragmentToProductDetailsFragment(getString(R.string.dummy_text))
            navController.navigate(directions)
        }

        buy_btn.setOnClickListener {
            val bundle = bundleOf(
                "description" to getString(R.string.dummy_text),
                "cost" to Money(25)
            )
            navController.navigate(R.id.action_productFragment_to_productCheckoutFragment, bundle)
        }
    }

}