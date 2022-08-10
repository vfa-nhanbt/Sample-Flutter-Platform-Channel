package com.example.flutter_platform_channel.PlatformChannel.EventChannel

import android.os.Handler
import android.os.Looper
import io.flutter.plugin.common.EventChannel

class DemoEventHandler : EventChannel.StreamHandler {
    companion object {
        val instance: DemoEventHandler by lazy { DemoEventHandler() }
    }

    private var sink: EventChannel.EventSink? = null
    private var handler: Handler? = null

    private var count: Int = 0

    private val runnable = object : Runnable {
        override fun run() {
            sink?.success(count++)
            handler?.postDelayed(this, 1000)
        }
    }

    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        sink = events
        handler = Handler(Looper.getMainLooper())
        handler?.postDelayed(runnable, 0)
    }

    override fun onCancel(arguments: Any?) {
        sink = null
        handler?.removeCallbacks(runnable)
    }
}