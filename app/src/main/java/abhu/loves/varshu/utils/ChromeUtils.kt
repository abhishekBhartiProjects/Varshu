package abhu.loves.varshu.utils

import abhu.loves.varshu.R
import abhu.loves.varshu.common.Constants
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

class ChromeUtils {
    fun openUrlInChrome(context: Context, url: String?){
        if (isChromeInstalled(context)){
            val builder = CustomTabsIntent.Builder()
            builder.setToolbarColor(ContextCompat.getColor(context, R.color.amazon_blue_black))
            builder.addDefaultShareMenuItem()
            builder.setShowTitle(true)
            builder.setExitAnimations(context, android.R.anim.fade_in, android.R.anim.fade_out)

            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(url ?: Constants.AMAZON_HOMEPAGE))
        } else {
//            DetailsActivity.start(context, url ?: Constants.AMAZON_HOMEPAGE)
        }
    }

    private fun isChromeInstalled(context: Context): Boolean {
        try {
            val packageInfo = context.packageManager.getPackageInfo("com.android.chrome", 0)
            if(packageInfo != null){
                return true
            }
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
        return false
    }
}