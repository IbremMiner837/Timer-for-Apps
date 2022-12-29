package com.jvmfrog.timerforapps;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

public class ActivityManagerHelper {
    public final Context context;

    public ActivityManagerHelper(Context context) {
        this.context = context;
    }

    public String getForegroundApp() {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = am.getRunningAppProcesses();
        String foregroundAppPackageName = null;
        for (ActivityManager.RunningAppProcessInfo processInfo : runningAppProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                foregroundAppPackageName = processInfo.processName;
            }
        }
        return foregroundAppPackageName;
    }
}
