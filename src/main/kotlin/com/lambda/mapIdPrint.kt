package com.lambda

import com.lambda.client.plugin.api.Plugin

import com.lambda.modules.mapIdPrintModule

internal object mapIdPrint : Plugin() {

    override fun onLoad() {
        modules.add(mapIdPrintModule)
    }

}