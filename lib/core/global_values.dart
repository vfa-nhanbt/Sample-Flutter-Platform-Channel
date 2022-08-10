import 'package:flutter/services.dart';

class GlobalValues {
  GlobalValues._internal();

  static const standardMethodChannel =
      MethodChannel('samples.flutter.dev/method-channel/standard');

  static const jsonMethodChannel = MethodChannel(
    'samples.flutter.dev/method-channel/json-codec',
    JSONMethodCodec(),
  );

  static const eventChannel =
      EventChannel('samples.flutter.dev/event-channel/standard');
}
