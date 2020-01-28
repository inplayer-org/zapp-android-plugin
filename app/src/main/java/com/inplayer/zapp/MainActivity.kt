package com.inplayer.zapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applicaster.hook_screen.HookScreenListener
import com.inplayer.zapp.kit.InPlayerLoginPlugin
import com.sdk.inplayer.callback.InPlayerNotificationCallback
import com.sdk.inplayer.configuration.InPlayer
import com.sdk.inplayer.model.error.InPlayerException
import com.sdk.inplayer.model.notification.InPlayerNotification
import com.sdk.inplayer.model.notification.InPlayerNotificationStatus
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        val ACCESS_GRANTED = "access.granted"
    }

    private val inPlayerLoginPlugin = InPlayerLoginPlugin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            inPlayerLoginPlugin.executeHook(this@MainActivity, mockHookListener(), mapOf())
        }
    }

    override fun onResume() {
        super.onResume()
        InPlayer.Notification.subscribe(object : InPlayerNotificationCallback {

            override fun onStatusChanged(status: InPlayerNotificationStatus) {}

            override fun onMessageReceived(message: InPlayerNotification) {
                if(message.type == ACCESS_GRANTED) {
                    inPlayerLoginPlugin.isItemLocked = true
                }
            }

            override fun onError(t: InPlayerException) {}

        })
    }

    override fun onPause() {
        super.onPause()
//        InPlayer.Notification.unsubscribe()
    }

    private fun mockHookListener() = object : HookScreenListener {
        override fun hookCompleted(hookProps: MutableMap<String, Any>?) {
        }

        override fun hookFailed(hookProps: MutableMap<String, Any>?) {
        }
    }
}
