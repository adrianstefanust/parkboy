package net.parkboy.parkboy.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_ticket.*
import net.parkboy.parkboy.util.adapter.Adapter
import net.parkboy.parkboy.R

class TicketFragment : Fragment() {

    lateinit var rootView: View

    private lateinit var ticketAdapter: Adapter
    private var ticketList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_ticket, container, false)

        initView()

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun initView() {
        ticketAdapter = Adapter(context!!.applicationContext, ticketList)
        rootView.news!!.layoutManager = GridLayoutManager(context!!.applicationContext, 1, 0, false)
        rootView.news!!.adapter = ticketAdapter
        PagerSnapHelper().attachToRecyclerView(rootView.news)
        rootView.news!!.isNestedScrollingEnabled = true

        ticketList.clear()
        ticketList.add("https://cdn.pixabay.com/photo/2014/04/02/16/19/barcode-306926_960_720.png")
        ticketList.add("https://cdn.pixabay.com/photo/2013/07/12/16/28/bar-code-150961_960_720.png")
        ticketList.add("https://cdn.pixabay.com/photo/2012/04/01/19/23/bar-code-24157_960_720.png")
        ticketAdapter.notifyDataSetChanged()
    }

    private fun init() {
        generate_qr.setOnClickListener {
            val text = editText.text.toString()
            val multiFormatWriter = MultiFormatWriter()
            try {
                val bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_128, 200, 200)
                val barcodeEncoder = BarcodeEncoder()
                val bitmap = barcodeEncoder.createBitmap(bitMatrix)
                imageView.setImageBitmap(bitmap)
            } catch (e: WriterException) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        fun newInstance(): TicketFragment = TicketFragment()
    }
}