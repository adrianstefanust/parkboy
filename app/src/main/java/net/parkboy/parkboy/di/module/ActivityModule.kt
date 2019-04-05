package net.parkboy.parkboy.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import net.parkboy.parkboy.ui.login.LoginContract
import net.parkboy.parkboy.ui.login.LoginPresenter

@Module
class ActivityModule(private var activity: Activity) {
    @Provides
    fun provideLoginPresenter(): LoginContract.Presenter {
        return LoginPresenter()
    }
}



