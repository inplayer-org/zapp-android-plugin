package com.inplayer.zapp

import com.applicaster.app.CustomApplication
import com.inplayer.zapp.kit.InPlayerLoginPlugin

class InPlayerApplication : CustomApplication() {

    override fun onCreate() {
        super.onCreate()
        InPlayerLoginPlugin.init(this, "cd3f233c-4045-47ef-bece-f7221b0bd07c", "http://example.com")
    }
}