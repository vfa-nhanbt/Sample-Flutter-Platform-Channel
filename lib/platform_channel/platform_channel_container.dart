import 'package:flutter/material.dart';
import 'package:flutter_platform_channel/platform_channel/event_channel.dart';
import 'package:flutter_platform_channel/platform_channel/method_channel.dart';

class PlatformChannelContainer extends StatelessWidget {
  const PlatformChannelContainer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: const [
          MethodChannel(),
          EventChannel(),
        ],
      ),
    );
  }
}
