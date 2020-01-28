package com.inplayer.zapp.kit.mocks

import com.applicaster.cam.IAnalyticsDataProvider
import com.applicaster.cam.PurchaseData
import com.applicaster.cam.Trigger

class AnalyticsDataProviderMock : IAnalyticsDataProvider {

    override var entityType: String = ""

    override var entityName: String = ""

    override var trigger: Trigger = Trigger.OTHER

    override val isUserSubscribed: Boolean
        get() = false

    override var purchaseData: MutableList<PurchaseData> = arrayListOf()
}