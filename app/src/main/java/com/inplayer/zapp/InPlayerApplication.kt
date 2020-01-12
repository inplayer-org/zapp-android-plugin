package com.inplayer.zapp

import android.app.Application
import com.sdk.inplayer.configuration.InPlayer


class InPlayerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InPlayer.initialize(
            InPlayer.Configuration.Builder(
                this,
                "cd3f233c-4045-47ef-bece-f7221b0bd07c"
            ) //Optional
                .withReferrer("zapp-ios-test") //Optional -Default is set to Production
                .withEnvironment(InPlayer.EnvironmentType.STAGING)
                .build()
        )
    }
}