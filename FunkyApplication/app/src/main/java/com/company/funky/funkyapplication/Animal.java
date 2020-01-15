package com.company.funky.funkyapplication;


public class Animal {
    private String name; // 动物的名称
    private int imageId; // 图片资源

    public Animal(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
}
