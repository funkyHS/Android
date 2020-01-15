package com.company.funky.funkyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends BaseActivity {

    /* 普通的 ListView 使用

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango","Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        // ArrayAdapter适配器可以通过泛型来指定要适配的数据类型
        // android.R.layout.simple_list_item_1 Android内置的布局文件，里面只有一个TextView

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    */

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);
        initFruits();

        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item_layout, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit("Apple" + i, R.drawable.apple);
            fruitList.add(apple);
        }

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }
}

