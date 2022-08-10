import 'package:flutter/material.dart';
import 'package:flutter_platform_channel/platform_channel/platform_channel_container.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Demo Platform Channel"),
          centerTitle: true,
        ),
        body: const Center(child: PlatformChannelContainer()),
      ),
    );
  }
}
