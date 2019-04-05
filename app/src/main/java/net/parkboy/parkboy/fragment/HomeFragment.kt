package net.parkboy.parkboy.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*
import net.parkboy.parkboy.util.adapter.Adapter
import net.parkboy.parkboy.R

class HomeFragment : Fragment() {

    lateinit var rootView: View

    private lateinit var newsAdapter: Adapter
    private lateinit var eventAdapter: Adapter
    private var newsList = ArrayList<String>()
    private var eventList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        initView()
        initViewE()

        return rootView
    }

    private fun initView() {
        newsAdapter = Adapter(context!!.applicationContext, newsList)
        rootView.news!!.layoutManager = GridLayoutManager(context!!.applicationContext, 1, 0, false)
        rootView.news!!.adapter = newsAdapter
        PagerSnapHelper().attachToRecyclerView(rootView.news)
        rootView.news!!.isNestedScrollingEnabled = true

        newsList.clear()
        newsList.add("http://pradnyastationary.com/wp-content/uploads/2017/09/Untitled.png")
        newsList.add("https://shopblog-web01.excite.co.id/wp-content/uploads/2016/05/special-promo.jpg")
        newsList.add("https://previews.123rf.com/images/djvstock/djvstock1511/djvstock151100087/47375563-shopping-promo-label-tag-graphic-design-vector-illustration-.jpg")
        newsAdapter.notifyDataSetChanged()
    }

    private fun initViewE() {
        eventAdapter = Adapter(context!!.applicationContext, eventList)
        rootView.events!!.layoutManager = GridLayoutManager(context!!.applicationContext, 1, 0, false)
        rootView.events!!.adapter = eventAdapter
        PagerSnapHelper().attachToRecyclerView(rootView.events)
        rootView.events!!.isNestedScrollingEnabled = true

        eventList.clear()
        eventList.add("https://www.sbb.ch/content/dam/internet/sharedimages/ff-uebersichtsseiten/Konzert_KeyVisual_Events.jpg.sbb-transform/original/Konzert_KeyVisual_Events.1533823126918.jpeg")
        eventList.add("https://res.cloudinary.com/dwzmsvp7f/image/fetch/q_75,f_auto,w_1316/https%3A%2F%2Fmedia.insider.in%2Fimage%2Fupload%2Fc_crop%2Cg_custom%2Fv1519627962%2Fvltlogy23k1iid9pjffx.jpg")
        eventList.add("https://www.sbb.ch/content/dam/internet/sharedimages/ff-uebersichtsseiten/Konzert_KeyVisual_Events.jpg.sbb-transform/original/Konzert_KeyVisual_Events.1533823126918.jpeg")
        eventAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}