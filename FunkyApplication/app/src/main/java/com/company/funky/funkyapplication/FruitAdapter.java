package com.company.funky.funkyapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    // 重写了父类的一组构造函数，用于将上下文，ListView子项布局的id和数据传递进来
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    // 此方法是在每个子项被滚动到屏幕内的时候会被调用
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // convertView 是用于将之前加载好的布局进行缓存，以便之后进行重用

        Fruit fruit = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder; // 用于对控件的实例进行缓存
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); // 将viewHolder 存储在view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取viewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    // 创建 ViewHolder 内部类
    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }

}
