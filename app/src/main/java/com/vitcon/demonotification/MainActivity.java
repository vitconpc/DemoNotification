package com.vitcon.demonotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int ID_DEFAULT = 1;
    private int number = 0;
    private static final String CHANNELID = "CHANNELID";
    private NotificationManagerCompat mNotificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManagerCompat = NotificationManagerCompat.from(this);
    }

    public void customNoti(View view) {
        RemoteViews collapsedView = new RemoteViews(getPackageName(),R.layout.layout_noti_collapsed);
        RemoteViews expandedView = new RemoteViews(getPackageName(),R.layout.notification_expanded);

        collapsedView.setTextViewText(R.id.tv_collapsed_1,"ahihi thay đổi title");
        expandedView.setImageViewResource(R.id.img,R.drawable.images);

        Intent clickIntent = new Intent(this,NotificationBroadcastReceiver.class);
        PendingIntent pendingClickIntent = PendingIntent.getBroadcast(this,1,clickIntent,0);

        expandedView.setOnClickPendingIntent(R.id.img,pendingClickIntent);

        Notification notification = new NotificationCompat.Builder(this,CHANNELID)
                .setSmallIcon(R.drawable.ic_notification_default)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setNumber(3)
                .build();
        mNotificationManagerCompat.notify(2,notification);
    }

    public void defaultNoti(View view) {
        Notification notification = new NotificationCompat.Builder(this, CHANNELID)
                .setSmallIcon(R.drawable.ic_notification_default)
                .setContentTitle("Vịt con")
                .setContentText("Đây là thông báo mặc định, gồm có title, icon, và nội dung")
                .setPriority(Notification.PRIORITY_MAX)
                .setVisibility(Notification.VISIBILITY_PRIVATE)
                .build();
        mNotificationManagerCompat.notify(ID_DEFAULT, notification);
    }
}
