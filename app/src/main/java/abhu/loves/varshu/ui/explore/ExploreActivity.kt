package abhu.loves.varshu.ui.explore

import abhu.loves.varshu.R
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

class ExploreActivity : AppCompatActivity() {

    @Parcelize
    @Keep
    data class ExploreActivityStartParams(
        val secondaryCategory: String
    ): Parcelable

    lateinit var startExtras: ExploreActivityStartParams
    companion object {
        val SECONDARY_CATEGORY = "secondary_category"
        val START_PARAMS = "start_params"

        fun start(context: Context, extras: ExploreActivityStartParams) {
            val intent = Intent(context, ExploreActivity::class.java)
            intent.putExtra(START_PARAMS, extras)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.explore_activity)

        init()
    }

    private fun init() {
        initArguments()
        initFragment()
    }

    private fun initArguments(){
        intent?.let {
            startExtras = intent.getParcelableExtra(START_PARAMS) ?: ExploreActivityStartParams("")
        }
    }

    private fun initFragment() {
        val bundle = Bundle()
        bundle.putString(SECONDARY_CATEGORY, startExtras.secondaryCategory)

        val fragment = ExploreFragment.newInstance(bundle)
        supportFragmentManager.beginTransaction().replace(R.id.explore_container_fl, fragment)
            .commit()
    }
}
