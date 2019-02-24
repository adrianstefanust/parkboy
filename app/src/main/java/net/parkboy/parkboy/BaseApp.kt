package net.parkboy.parkboy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class BaseApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_home)
    }
}
