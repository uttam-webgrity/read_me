package com.uttam.read_me

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.uttam.read_me/notification_channel"

    // Override configureFlutterEngine to set up the method channel
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        // Set up the method channel to handle communication from Flutter to native
        MethodChannel(flutterEngine.dartExecutor, CHANNEL).setMethodCallHandler { call, result ->
            when (call.method) {
                "startListening" -> {
                    startNotificationListener()
                    result.success("Listening started")
                }
                "stopListening" -> {
                    stopNotificationListener()
                    result.success("Listening stopped")
                }
                else -> result.notImplemented()
            }
        }
    }

    // Method to start notification listener
    private fun startNotificationListener() {
        val intent = Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")
        startActivity(intent)
    }

    // Method to stop notification listener (if necessary)
    private fun stopNotificationListener() {
        // This might be redundant as the listener service runs in the background
        println("Notification Listener Stopped")
    }
}
