package com.example.flutter_platform_channel

import androidx.annotation.NonNull
import com.example.flutter_platform_channel.PlatformChannel.DemoEventChannel
import com.example.flutter_platform_channel.PlatformChannel.DemoMethodChannel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine


class MainActivity : FlutterActivity() {

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        DemoMethodChannel.instance.standardMethodChannel(flutterEngine)
        DemoMethodChannel.instance.jsonMethodChannel(flutterEngine)

        DemoEventChannel.instance.standardEventChannel(flutterEngine)

        /*
            standardMethodChannel(flutterEngine)
            jsonMethodChannel(flutterEngine)
           */
    }

    /*
    private fun standardMethodChannel(@NonNull flutterEngine: FlutterEngine) {
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

    private fun jsonMethodChannel(@NonNull flutterEngine: FlutterEngine) {
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
    }*/

}
