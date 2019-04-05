package net.parkboy.parkboy.di.component

import dagger.Component
import net.parkboy.parkboy.BaseApp
import net.parkboy.parkboy.di.module.ApplicationModule

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: BaseApp)
}