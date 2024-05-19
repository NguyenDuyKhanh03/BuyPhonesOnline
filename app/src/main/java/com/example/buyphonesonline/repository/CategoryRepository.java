package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private final DatabaseHandler databaseHandler;

    public CategoryRepository(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public void addCategory(String name){
        SQLiteDatabase db=databaseHandler.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(DatabaseHandler.CATEGORY_NAME,name);
        db.insert(DatabaseHandler.TABLE_CATEGORY,null,values);
        db.close();
    }

    public Category getCategory(String name){
        SQLiteDatabase db=databaseHandler.getReadableDatabase();
        Cursor cursor = db.query(
                DatabaseHandler.TABLE_CATEGORY,
                null,
                DatabaseHandler.CATEGORY_NAME + "=?",
                new String[]{name},
                null,
                null,
                null
        );
        Category category = null;
        if(cursor!=null){
            cursor.moveToFirst();
            category=new Category(cursor.getInt(0),cursor.getString(1));
        }
        return category;

    }


    public List<Category> getAllCategory(){
        List<Category> categories=new ArrayList<>();
        SQLiteDatabase db=databaseHandler.getReadableDatabase();
        String[] projection={
                DatabaseHandler.CATEGORY_ID,
                DatabaseHandler.CATEGORY_NAME
        };
        Cursor cursor=db.query(
                DatabaseHandler.TABLE_CATEGORY,
                projection,
                null,
                null,
                null,null,
                null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){ // cursor chua la dong cuoi là false
            Category category=new Category(cursor.getInt(0),cursor.getString(1));
            categories.add(category);
            cursor.moveToNext();
        }
        return categories;
    }

}
