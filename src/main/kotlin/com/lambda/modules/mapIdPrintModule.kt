package com.lambda.modules

import com.lambda.client.event.events.PacketEvent
import com.lambda.mapIdPrint
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.threads.safeListener
import net.minecraft.network.play.server.SPacketMaps
import com.lambda.client.util.text.MessageSendHelper

internal object mapIdPrintModule : PluginModule(
    name = "Map ID Printer",
    category = Category.MISC,
    description = "Print the ID of maps sent by the server.",
    pluginMain = mapIdPrint
) {
    private var lastId: Int? = null

    init {
        safeListener<PacketEvent.Receive> {
            if (it.packet is SPacketMaps) {

                if((it.packet as SPacketMaps).mapId == lastId) return@safeListener //prevent spam of same id

                MessageSendHelper.sendChatMessage("Map ID: " + (it.packet as SPacketMaps).mapId + " || Last ID: " + lastId + ".")

                lastId = (it.packet as SPacketMaps).mapId

            }
        }
    }
}