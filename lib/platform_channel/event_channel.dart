import 'package:flutter/material.dart';
import 'package:flutter_platform_channel/core/global_values.dart';

class EventChannel extends StatelessWidget {
  const EventChannel({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return StreamBuilder(
      stream: GlobalValues.eventChannel.receiveBroadcastStream(),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return Text(
              "Time connection between Flutter and Native Android code: ${snapshot.data}");
        } else {
          return const Text("Waiting for connection...");
        }
      },
    );
  }
}
