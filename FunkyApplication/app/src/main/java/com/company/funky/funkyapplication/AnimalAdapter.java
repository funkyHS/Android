package com.company.funky.funkyapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> mAnimalList;

    // 定义一个内部类 ViewHolder 继承自 RecyclerView.ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        View animalView;
        ImageView animalImage;
        TextView animalName;

        // ViewHolder的构造函数中要穿入一个view参数
        public ViewHolder(View view) {
            super(view);
            animalView = view;
            animalImage = (ImageView) view.findViewById(R.id.animal_image);
            animalName = (TextView) view.findViewById(R.id.animal_name);
        }
    }

    // 要把展示的数据源传进来
    public AnimalAdapter(List<Animal> animalList) {
        mAnimalList = animalList;
    }



    // 由于 AnimalAdapter 继承自 RecyclerView.Adapter，所以必须重写下面的3个方法

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        // 将animal_item_layout的布局加载进来，同时创建ViewHolder实例
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item_layout, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.animalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(), "you click view" + animal.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.animalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Animal animal = mAnimalList.get(position);
                Toast.makeText(v.getContext(), "you click image " + animal.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        // 在每个子项cell被滚动到屏幕内的时候执行，然后在设置其数据
        Animal animal = mAnimalList.get(position);
        viewHolder.animalImage.setImageResource(animal.getImageId());
        viewHolder.animalName.setText(animal.getName());
    }

    @Override
    public int getItemCount() {
        // 用于告诉RecyclerView一共有多少子项 cell
        return mAnimalList.size();
    }
}
