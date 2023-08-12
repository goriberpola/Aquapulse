package com.example.aquapulse;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

public class NotificationActivity extends BroadcastReceiver {



    private static final String CHANNEL_ID = "notification_channel";
    private static final int NOTIFICATION_ID = 123; // Unique ID for the notification




    @Override
    public void onReceive(Context context, Intent intent) {

        showNotification(context);
    }
    public void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Set the alarm to trigger every 1.5 hours
        long intervalMillis =  10L * 1000L; // 1.5 hours in milliseconds
        long triggerTime = SystemClock.elapsedRealtime() + intervalMillis;

        if (alarmManager != null) {
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, intervalMillis, pendingIntent);
        }
    }

    private void showNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a notification channel (required for Android 8.0 and above)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "App Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_water)


                .setContentTitle("App Notification")
                .setContentText("It's time to check the app!")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)


                .setPriority(NotificationCompat.PRIORITY_HIGH) ;// Set high priority



        Notification notification = builder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
    private PendingIntent getFullScreenIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class); // Replace with your activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

}