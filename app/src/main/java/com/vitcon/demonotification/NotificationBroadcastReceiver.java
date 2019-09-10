package com.vitcon.demonotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "close all notification", Toast.LENGTH_SHORT).show();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
//        notificationManagerCompat.cancel(1);
        notificationManagerCompat.cancelAll();
    }
}
