package com.example.flutter_platform_channel.PlatformChannel

import androidx.annotation.NonNull
import com.example.flutter_platform_channel.PlatformChannel.EventChannel.DemoEventHandler
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.EventChannel

class DemoEventChannel {
    companion object {
        val instance: DemoEventChannel by lazy { DemoEventChannel() }
    }

    private val standardEventChannelName = "samples.flutter.dev/event-channel/standard"
    private var count = 0

    fun standardEventChannel(@NonNull flutterEngine: FlutterEngine) {
        EventChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            standardEventChannelName
        ).setStreamHandler(
            DemoEventHandler.instance
        )
    }
}