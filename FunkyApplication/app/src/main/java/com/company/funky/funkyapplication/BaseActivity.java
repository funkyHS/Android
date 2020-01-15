package com.company.funky.funkyapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }

    // 销毁所有活动代码
    // ActivityCollector.finishAll();

    // 杀掉当前进程的代码
    // android.os.Process.killProcess(android.os.Process.myPid());


}
