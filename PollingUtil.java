//package com.ximalaya.ting.android.xmtrace;
//
//import android.app.AlarmManager;
//import android.app.PendingIntent;
//import android.content.Context;
//import android.content.Intent;
//import android.os.SystemClock;
//
///**
// * 开始和停止轮询服务
// * Created by luhang on 2018/1/16.
//* @author luhang    
// */    
//
 public class PollingUtil{       

     public static final long POLL_TIME = 2 * 60 * 60;//秒

//    public static boolean startPoll(Context context, long pollTime, Class<?> cls, String action) {
//        if (context == null) {
//            return false;
//        }
//        if (pollTime <= 0) {
//            pollTime = POLL_TIME;
//        }
//        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        if (alarmManager == null) {
//            return false;
//        }
//        Intent intent = new Intent(context, cls);
//        intent.setAction(action);
//        long triggerAtTime = SystemClock.elapsedRealtime();
//        pollTime = pollTime * 1000;// 毫秒
//        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime + pollTime, pollTime, pendingIntent);
//        return true;
//    }
//
//    public static void stopPoll(Context context, Class<?> cls, String action) {
//        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//        if (manager == null) {
//            return;
//        }
//        Intent intent = new Intent(context, cls);
//        intent.setAction(action);
//        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        //取消正在执行的服务
//        manager.cancel(pendingIntent);
//    }
}
