package com.company.funky.funkyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


// SecondActivity 类中

public class SecondActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("param1");
        String str2 = intent.getStringExtra("param2");
        Log.d("SecondActivity", str1 + " " + str2);

    }

    public static void actionStart(Context context, String str1, String str2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", str1);
        intent.putExtra("param2", str2);
        context.startActivity(intent);
    }
}
