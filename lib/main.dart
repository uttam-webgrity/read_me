import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  static const platform = MethodChannel('com.uttam.read_me/notification_channel');

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Notification Listener"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                onPressed: () {
                  _startListening();
                },
                child: Text("Start Listening"),
              ),
              ElevatedButton(
                onPressed: () {
                  _stopListening();
                },
                child: Text("Stop Listening"),
              ),
            ],
          ),
        ),
      ),
    );
  }

  // Start listening for notifications
  Future<void> _startListening() async {
    try {
      final String result = await platform.invokeMethod('startListening');
      print("####LISTNING####");
      print(result);
    } on PlatformException catch (e) {
      print("Failed to start listening: '${e.message}'.");
    }
  }

  // Stop listening for notifications
  Future<void> _stopListening() async {
    try {
      final String result = await platform.invokeMethod('stopListening');
      print(result);
    } on PlatformException catch (e) {
      print("Failed to stop listening: '${e.message}'.");
    }
  }
}
