package abhu.loves.varshu.ui.navFlow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import abhu.loves.varshu.R
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.product_checkout_fragment.*

private const val ARG_DESCRIPTION = "description"
private const val ARG_COST = "cost"

class ProductCheckoutFragment : Fragment() {
    private var description: String? = null
    private var cost: Int = 0

    lateinit var navController: NavController

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductCheckoutFragment().apply {
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_checkout_fragment, container, false)
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
            description = it.getString(ARG_DESCRIPTION)
            cost = (it!!.getParcelable<Money>(ARG_COST))!!.cost
        }
    }

    private fun initViews() {
        description_tv.text = description
        cost_tv.text = "Rs. $cost/-"
    }

    private fun initNavController(view: View){
        navController = Navigation.findNavController(view)
    }

    private fun initClickListener() {
        back_iv.setOnClickListener {
            activity?.let {
                activity!!.onBackPressed()
            }
        }

        buy_btn.setOnClickListener {
            Toast.makeText(requireContext(), "Purchase done!", Toast.LENGTH_SHORT).show()
        }
    }


}
