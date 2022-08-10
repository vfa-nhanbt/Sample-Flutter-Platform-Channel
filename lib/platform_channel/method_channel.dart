import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_platform_channel/core/global_values.dart';

class MethodChannel extends StatefulWidget {
  const MethodChannel({Key? key}) : super(key: key);

  @override
  State<MethodChannel> createState() => _MethodChannelState();
}

class _MethodChannelState extends State<MethodChannel> {
  String deviceInfo = "Display device information";

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Text(deviceInfo),
        ElevatedButton(
          onPressed: standardMethodChannel,
          child: const Text("Get DeviceInfo"),
        ),
      ],
    );
  }

  standardMethodChannel() async {
    try {
      await GlobalValues.standardMethodChannel
          .invokeMethod<String?>('getDeviceInfo', {
        "type": "MODEL",
      }).then((value) => deviceInfo = value ?? "Cannot get device information");
    } on PlatformException catch (e) {
      deviceInfo = e.message!;
    }
    setState(() {
      jsonMethodChannel();
    });
  }

  jsonMethodChannel() async {
    try {
      await GlobalValues.jsonMethodChannel.invokeMethod('getDeviceInfoJson', {
        "type": "MODEL",
      }).then((value) => log(value.toString()));
    } on PlatformException catch (e) {
      log(e.message!);
    }
  }
}
