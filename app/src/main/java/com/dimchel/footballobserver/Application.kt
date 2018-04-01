package com.dimchel.footballobserver

import android.app.Application
import com.dimchel.footballobserver.di.component.AppComponent
import com.dimchel.footballobserver.di.component.DaggerAppComponent
import com.dimchel.footballobserver.di.manager.DiManager
import com.dimchel.footballobserver.di.manager.DiManagerImpl
import com.dimchel.footballobserver.di.module.AppModule
import com.dimchel.footballobserver.di.module.NetworkModule


class Application : Application() {

    companion object {
        lateinit var instance: com.dimchel.footballobserver.Application
    }

    private lateinit var appComponent: AppComponent
    private lateinit var diManager: DiManager


    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = initAppComponent()
        diManager = DiManagerImpl(appComponent)
    }

    // ===========================================================
    // di
    // ===========================================================

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(AppConstants.BASE_API_URL))
                .build()
    }

    public fun getDiManager(): DiManager {
        return diManager
    }

}