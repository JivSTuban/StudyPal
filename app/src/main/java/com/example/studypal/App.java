package com.example.studypal;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    private void createNotificationChannel(){
         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
             NotificationChannel channel = new NotificationChannel("channel", "Channel!", NotificationManager.IMPORTANCE_HIGH);
               channel.setDescription("Welcome to study pal, pal!");

             NotificationManager manager=getSystemService(NotificationManager.class);
             manager.createNotificationChannel(channel);

         }



    }

}
