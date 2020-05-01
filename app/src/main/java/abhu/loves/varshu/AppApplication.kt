package abhu.loves.varshu

import abhu.loves.varshu.common.Constants
import android.app.Application

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        Constants.createSecondaryCategoryMap()
    }
}