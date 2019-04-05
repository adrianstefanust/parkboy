package net.parkboy.parkboy.ui.wallet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_wallet.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.util.adapter.Adapter

class WalletActivity : AppCompatActivity() {

    private lateinit var couponAdapter: Adapter
    private var couponList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)

        initView()
    }

    private fun initView() {
        couponAdapter = Adapter(this.applicationContext, couponList)
        coupon.layoutManager = GridLayoutManager(this.applicationContext, 1, 0, false)
        coupon.adapter = couponAdapter
        PagerSnapHelper().attachToRecyclerView(coupon)
        coupon.isNestedScrollingEnabled = true

        couponList.clear()
        couponList.add("https://nedstevens.com/Images/support/diamond-service-gutter-cleaning-coupons.png")
        couponList.add("https://res.cloudinary.com/dwzmsvp7f/image/fetch/q_75,f_auto,w_1316/https%3A%2F%2Fmedia.insider.in%2Fimage%2Fupload%2Fc_crop%2Cg_custom%2Fv1519627962%2Fvltlogy23k1iid9pjffx.jpg")
        couponList.add("https://www.maverickadvantage.net/wp-content/uploads/2017/06/10Off-Coupon.png")
        couponList.add("https://www.maverickadvantage.net/wp-content/uploads/2017/06/10Off-Coupon.png")
        couponList.add("https://www.maverickadvantage.net/wp-content/uploads/2017/06/10Off-Coupon.png")
        couponAdapter.notifyDataSetChanged()
    }
}