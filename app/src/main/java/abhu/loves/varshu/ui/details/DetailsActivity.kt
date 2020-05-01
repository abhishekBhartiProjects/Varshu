package abhu.loves.varshu.ui.details

import abhu.loves.varshu.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.details_activity.*

class DetailsActivity : AppCompatActivity() {

    var loadUrl: String? = null
    companion object{
        val LOAD_URL = "load_url"
        fun start(context: Context, url: String) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(LOAD_URL, url)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)

        init()
    }

    private fun init(){
        initBundle()
        initViews()
    }

    private fun initBundle(){
        intent?.let {
            loadUrl = intent.getStringExtra(LOAD_URL)
        }
    }

    private fun initViews(){
        loadUrl?.let {
            details_webview.loadUrl(loadUrl)
        }
    }
}
