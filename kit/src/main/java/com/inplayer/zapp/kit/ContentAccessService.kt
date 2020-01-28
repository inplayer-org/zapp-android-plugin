package com.inplayer.zapp.kit

import android.content.Context
import androidx.annotation.NonNull
import com.applicaster.cam.ContentAccessManager
import com.applicaster.cam.ICamContract

/**
 * Sample class that is responsive for communication between login plugin (see [SampleLoginPlugin])
 * and [ICamContract]
 * Can hold information that is related to the current session such as plugin configuration & so on
 */
class ContentAccessService {

    var pluginConfig: Map<String, String> = emptyMap()

    var camContract: InPlayerCamContract = InPlayerCamContract(this)

    fun launchCam(@NonNull context: Context){
        ContentAccessManager.onProcessStarted(camContract, context)
    }
}