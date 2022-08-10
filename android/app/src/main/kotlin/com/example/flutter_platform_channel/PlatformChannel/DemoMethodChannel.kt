package com.example.flutter_platform_channel.PlatformChannel

import android.os.Build
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.JSONMethodCodec
import io.flutter.plugin.common.MethodChannel
import org.json.JSONException
import org.json.JSONObject

class DemoMethodChannel {
    companion object {
        val instance: DemoMethodChannel by lazy { DemoMethodChannel() }
    }

    private val standardMethodChannelName = "samples.flutter.dev/method-channel/standard"
    private val jsonMethodChannelName = "samples.flutter.dev/method-channel/json-codec"

    fun standardMethodChannel(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            standardMethodChannelName
        ).setMethodCallHandler {
            // This method is invoked on the main thread
                call, result ->
            when (call.method) {
                "getDeviceInfo" -> {
                    val type: String? = call.argument("type")
                    if (type == null || type.isEmpty()) {
                        result.error("NullPointerException", "Type cannot be empty", null)
                        return@setMethodCallHandler
                    }
                    return@setMethodCallHandler result.success(getDeviceInfoString(type))
                }
                else -> result.notImplemented()
            }
        }
    }

    private fun getDeviceInfoString(type: String): String? {
        if (type == "MODEL") {
            return Build.MODEL
        }
        return null
    }

    fun jsonMethodChannel(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            jsonMethodChannelName,
            JSONMethodCodec.INSTANCE
        ).setMethodCallHandler { call, result ->
            when (call.method) {
                "getDeviceInfoJson" -> {
                    val type: String? = call.argument("type")
                    if (type == null || type.isEmpty()) {
                        result.error("NullPointerException", "Type cannot be empty", null)
                        return@setMethodCallHandler
                    }
                    return@setMethodCallHandler result.success(getDeviceInfoJson(type))
                }
                else -> result.notImplemented()
            }
        }
    }

    private fun getDeviceInfoJson(type: String): JSONObject? {
        val json: JSONObject = JSONObject()
        if (type == "MODEL") {
            try {
                json.put("result", Build.MODEL.toString())
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return json
        }
        return null
    }
}