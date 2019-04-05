package net.parkboy.parkboy.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import net.parkboy.parkboy.BaseApp
import net.parkboy.parkboy.di.scope.PerApplication
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {
    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}