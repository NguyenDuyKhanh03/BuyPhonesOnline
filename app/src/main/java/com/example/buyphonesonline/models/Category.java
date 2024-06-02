package com.example.buyphonesonline.models;

import com.example.buyphonesonline.R;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private Long CateId;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(int id, String name, Long cateId) {
        this.id = id;
        this.name = name;
        CateId = cateId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long CateId() {
        return CateId;
    }

    public void setCateId(Long cateId) {
        CateId = cateId;
    }

//    public static List<Category> getAllCate(){
//        List<Category> categories=new ArrayList<>();
//        categories.add(new Category(R.drawable.meat,"Thịt và hải sản",1L));
//        categories.add(new Category(R.drawable.meat_egg,"Rau củ quả",2L));
//        categories.add(new Category(R.drawable.meat_egg,"Trái cây",3L));
//        categories.add(new Category(R.drawable.drink,"Đồ uống",4L));
//        return categories;
//    }
}
