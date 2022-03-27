package com.lambda

import com.lambda.client.plugin.api.Plugin

import com.lambda.modules.mapIdPrintModule

internal object mapIdPrint : Plugin() {

    override fun onLoad() {
        // Load any modules, commands, or HUD elements here
        modules.add(mapIdPrintModule)

    }

    override fun onUnload() {
        // Here you can unregister threads etc...
    }
}