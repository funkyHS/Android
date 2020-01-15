package com.company.funky.funkyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);
        initAnimals();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
    /*
        // LayoutManager用于指定RecyclerView的布局方式，这里使用的是线性布局的意思
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 设置布局的排列方向（默认是纵向排列的）
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    */


        // 第一个参数，表示布局的列数，3表示3列
        // 第二个参数代表布局的排列方向 VERTICAL表示让布局纵向排列
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        AnimalAdapter adapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(adapter);
    }

    private void initAnimals() {
        for (int i = 0; i < 20; i++) {
            Animal animal = new Animal(getRandomLengthName("Dog"), R.drawable.dog);
            animalList.add(animal);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }



    public static void actionStart(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }
}
