package net.parkboy.parkboy.ui.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.view_home.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.news.News1Frag
import net.parkboy.parkboy.news.News2Frag
import net.parkboy.parkboy.ui.map.MapActivity
import net.parkboy.parkboy.util.ViewPageAdapter

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_home)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val showMapActivity = Intent(view!!.context, MapActivity::class.java)
            view.context.startActivity(showMapActivity)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initView()
    }

    private fun initView() {
        val viewPager: ViewPager = findViewById(R.id.news)
        val adapter: ViewPageAdapter = ViewPageAdapter(supportFragmentManager)

        adapter.AddFragment(News1Frag(), "")
        adapter.AddFragment(News2Frag(), "")
        viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
