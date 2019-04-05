package net.parkboy.parkboy.di.component

import dagger.Component
import net.parkboy.parkboy.ui.login.LoginActivity
import net.parkboy.parkboy.di.module.ActivityModule

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
}