package net.parkboy.parkboy

import android.app.Application
import net.parkboy.parkboy.di.component.ApplicationComponent
import net.parkboy.parkboy.di.component.DaggerApplicationComponent
import net.parkboy.parkboy.di.module.ApplicationModule
import net.parkboy.parkboy.util.Pref

class BaseApp : Application() {
    companion object {
        lateinit var instance: BaseApp private set
        lateinit var pref: Pref
    }

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        pref = Pref(applicationContext)
        instance = this
        setup()

        if (BuildConfig.DEBUG) {
            // Maybe TimberPlant etc.
        }
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }
}