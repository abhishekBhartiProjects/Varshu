package abhu.loves.varshu.ui.home

import abhu.loves.varshu.R
import abhu.loves.varshu.ui.home.data.model.customModel.Card
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_wishcard_child_item.*
import java.util.zip.Inflater

class WishCardFragment: Fragment() {

    companion object {
        fun newInstance(bundle: Bundle) = WishCardFragment().apply { arguments = bundle }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.item_wishcard_child_item, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView(){
        val options: RequestOptions = RequestOptions()
            .fallback(R.drawable.img_default)
            .error(R.drawable.img_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        val card = requireArguments().get("card") as Card

        Glide.with(context)
            .load(Uri.parse(card.imageUrl))
            .apply(options)
            .into(img_iv)
    }
}