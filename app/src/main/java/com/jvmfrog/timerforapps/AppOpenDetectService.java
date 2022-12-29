package com.jvmfrog.timerforapps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class AppOpenDetectService extends Service {
    private ActivityManagerHelper managerHelper;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        managerHelper = new ActivityManagerHelper(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (managerHelper.getForegroundApp().equals("com.bytedance"))
            intent = new Intent(this, TimerForOpenedApp.class);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
