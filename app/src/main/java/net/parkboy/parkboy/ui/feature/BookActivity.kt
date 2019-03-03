package net.parkboy.parkboy.ui.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import net.parkboy.parkboy.R
import java.util.*


class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_book)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, "YOUR_API_KEY")
        }

        val autocompleteFragment = AutocompleteSupportFragment()
        supportFragmentManager.findFragmentById(R.id.autocomplete_fragment)

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME))

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                Log.i("Place", "Place: " + place.name + ", " + place.id)
            }

            override fun onError(status: Status) {
                Log.i("Eror", "An error occurred: $status")
            }
        })
    }
}