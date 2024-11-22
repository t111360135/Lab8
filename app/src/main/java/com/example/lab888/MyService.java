package com.example.lab888;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() { //使用 Thread 來模擬執行耗時任務
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); //延遲 5 秒
                    Intent intent = new Intent(MyService.this, MainActivity2.class); //啟動 MainActivity2
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //Service 要啟動 Activity 要加入 Flag 定義一個新任務去產生 Activity
                    MyService.this.startActivity(intent);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY; //Service 被結束時會重啟並清空 Intent
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        //TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}