package abhu.loves.varshu.utils

import abhu.loves.varshu.R
import abhu.loves.varshu.ui.home.HomeViewModel
import abhu.loves.varshu.ui.home.data.model.Entry
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class FamilyUtils {
    companion object {
        private val options: RequestOptions = RequestOptions()
            .fallback(R.drawable.img_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)

        fun bindView(
            container: View,
            textView: TextView,
            imageView: ImageView,
            product: Entry,
            viewModel: HomeViewModel
        ) {
            container.visibility = View.VISIBLE
            textView.text = product.text.value ?: ""
            Glide.with(textView.context)
                .load(product.image.value ?: "")
                .apply(options)
                .into(imageView)

            container.setOnClickListener {
                viewModel.onProductClick(product)
            }
        }
    }
}