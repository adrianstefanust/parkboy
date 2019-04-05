package net.parkboy.parkboy.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import net.parkboy.parkboy.R

class PlaceFragment : Fragment(), OnMapReadyCallback {

    lateinit var rootView: View
    private lateinit var fMap: GoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_place, container, false)

        val fragment = childFragmentManager.findFragmentById(R.id.frag_map)
        val mapFragment = fragment as SupportMapFragment
        mapFragment.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(map: GoogleMap?) {
        fMap = map!!

        if (ActivityCompat.checkSelfPermission(context!!.applicationContext,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), PlaceFragment.LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

        fMap.isMyLocationEnabled = true
        fMap.uiSettings.isZoomControlsEnabled = true
        fMap.uiSettings.isMyLocationButtonEnabled = true
        fMap.uiSettings.isMapToolbarEnabled = true
        fMap.uiSettings.isCompassEnabled = true
    }

    companion object {
        fun newInstance(): PlaceFragment = PlaceFragment()

        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}