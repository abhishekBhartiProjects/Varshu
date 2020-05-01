package abhu.loves.varshu.ui.home

import abhu.loves.varshu.R
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.home_activity.*
import kotlinx.android.synthetic.main.include_container.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        initActionBar()
        initNav()
        initFragment()
    }

    private fun initActionBar(){
        setSupportActionBar(toolbar)
        toolbar.title = "Amazon"
        actionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.amazon_blue_black)))
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_hamburger)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        //change status bar color
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun initNav(){
        setupDrawerContent(nav_view)
    }

    private fun initFragment(){
        val fragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, HomeFragment.TAG)
            .commit()
    }

    private fun setupDrawerContent(navigationView: NavigationView) {

        if (navigationView.getMenu().size() > 0)
            navigationView.getMenu().getItem(0).setChecked(false);
        if (navigationView.getMenu().size() > 1)
            navigationView.getMenu().getItem(1).setChecked(true);
        if (navigationView.getMenu().size() > 2)
            navigationView.getMenu().getItem(2).setChecked(false);
        if (navigationView.getMenu().size() > 3)
            navigationView.getMenu().getItem(3).setChecked(false);
        if (navigationView.getMenu().size() > 4)
            navigationView.getMenu().getItem(4).setChecked(false);
        if (navigationView.getMenu().size() > 5)
            navigationView.getMenu().getItem(5).setChecked(false);
        if (navigationView.getMenu().size() > 6)
            navigationView.getMenu().getItem(6).setChecked(false);


        navigationView.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                item.setChecked(false)
                drawer_layout.closeDrawers()
                when(item.itemId){
                    R.id.nav_1 -> {
                        Toast.makeText(navigationView.context, "Working", Toast.LENGTH_SHORT).show()

                        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("testbook://tbapp/testseries/"))
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        navigationView.context.startActivity(intent)
                    }
                    R.id.nav_2 -> {}
                    else -> {}

                }
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }
}
