package net.parkboy.parkboy.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.recycler_news.view.*
import kotlinx.android.synthetic.main.view_content.*
import kotlinx.android.synthetic.main.view_home.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.ui.feature.AvailableActivity
import net.parkboy.parkboy.ui.feature.BookActivity
import net.parkboy.parkboy.ui.feature.ParkActivity
import net.parkboy.parkboy.ui.feature.WalletActivity
import net.parkboy.parkboy.ui.map.MapActivity

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var newsAdapter: NewsAdapter

    private var doubleBackToExitPressedOnce = false
    private var newsList = ArrayList<String>()

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
        initBtn()
    }

    private fun initView() {
        newsAdapter = NewsAdapter(this.applicationContext, newsList)
        news!!.layoutManager = GridLayoutManager(this.applicationContext, 1, 0, false)
        news!!.adapter = newsAdapter
        PagerSnapHelper().attachToRecyclerView(news)
        news!!.isNestedScrollingEnabled = true

        newsList.clear()
        newsList.add("http://pradnyastationary.com/wp-content/uploads/2017/09/Untitled.png")
        newsList.add("https://shopblog-web01.excite.co.id/wp-content/uploads/2016/05/special-promo.jpg")
        newsList.add("https://previews.123rf.com/images/djvstock/djvstock1511/djvstock151100087/47375563-shopping-promo-label-tag-graphic-design-vector-illustration-.jpg")
        newsAdapter.notifyDataSetChanged()
    }

    private fun initBtn() {
        btn_book.setOnClickListener {
            val intent = Intent(this, BookActivity::class.java)
            startActivity(intent)
        }
        btn_available.setOnClickListener {
            val intent = Intent(this, AvailableActivity::class.java)
            startActivity(intent)
        }
        btn_park.setOnClickListener {
            val intent = Intent(this, ParkActivity::class.java)
            startActivity(intent)
        }
        btn_wallet.setOnClickListener {
            val intent = Intent(this, WalletActivity::class.java)
            startActivity(intent)
        }
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

    inner class NewsAdapter(var context: Context, var newsList: ArrayList<String>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): NewsAdapter.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return ViewHolder(inflater.inflate(R.layout.recycler_news, parent, false))
        }

        override fun getItemCount(): Int = newsList.size

        override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, pos: Int) {
            holder.bindView()
            holder.itemView.setOnClickListener { }
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bindView() {
                Glide.with(context).load(newsList[adapterPosition])
                    .into(itemView.newsHead)
            }
        }
    }
}
