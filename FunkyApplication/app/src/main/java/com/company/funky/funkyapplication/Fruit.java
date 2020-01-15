package com.company.funky.funkyapplication;

public class Fruit {
    private String name; // 水果的名称
    private int imageId; // 图片资源

    public Fruit(String name, int imageId) {
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
