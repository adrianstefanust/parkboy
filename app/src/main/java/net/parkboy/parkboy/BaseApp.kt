package net.parkboy.parkboy

import android.app.Application
import net.parkboy.parkboy.util.Pref

class BaseApp : Application() {

    companion object {
        lateinit var instance: BaseApp private set
        lateinit var pref: Pref
    }

    override fun onCreate() {
        super.onCreate()

        pref = Pref(applicationContext)
        instance = this

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }
}
