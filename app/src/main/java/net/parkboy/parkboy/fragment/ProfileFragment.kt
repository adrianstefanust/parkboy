package net.parkboy.parkboy.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_profile.view.*
import net.parkboy.parkboy.R
import net.parkboy.parkboy.ui.wallet.WalletActivity

class ProfileFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        initView()

        return rootView
    }

    fun initView() {
        Glide.with(this)
                .load("https://blog.fuertehoteles.com/wp-content/uploads/2016/07/parking.jpg")
//                .load("https://www.nmtv.tv/wp-content/uploads/2017/04/underground-parking.jpg")
                .into(rootView.imageProfile)

        rootView.wallet.setOnClickListener {
            val intent = Intent(context, WalletActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance(): ProfileFragment = ProfileFragment()
    }
}