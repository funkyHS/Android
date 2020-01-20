package com.company.funky.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "recive in MyBroadcastReceiver", Toast.LENGTH_LONG).show();

        // 表示将这条广播截断，终止传递，后面的接收器将无法在接收到这条广播
        abortBroadcast();
    }
}
