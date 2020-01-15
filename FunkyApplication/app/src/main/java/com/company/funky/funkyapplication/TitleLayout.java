package com.company.funky.funkyapplication;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {


    // 引入控件，就会调用这个构造函数
    // inflate(R.layout.title_layout, this) 方法可以动态的加载一个布局文件
    // 第一个参数是要加载的布局文件的id，第二个参数是给加载好的布局再添加一个父布局

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);

        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You Click Edit Btn", Toast.LENGTH_LONG).show();
            }
        });
    }
}
