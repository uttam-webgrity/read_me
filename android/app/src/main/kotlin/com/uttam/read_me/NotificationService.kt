package com.uttam.read_me

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationService : NotificationListenerService() {
    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        val notificationTitle = sbn?.notification?.extras?.getString("android.title")
        val notificationText = sbn?.notification?.extras?.getString("android.text")
        Log.d("NotificationListener", "Notification Posted: $notificationTitle - $notificationText")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.d("NotificationListener", "Notification Removed: ${sbn?.packageName}")
    }
}
