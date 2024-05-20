package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Images;
import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ImagesRepository {
    private DatabaseHandler databaseHandler;

    public ImagesRepository(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public void addImages(Images images){
        SQLiteDatabase db=databaseHandler.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(DatabaseHandler.IMAGE_NAME,images.name());
        values.put(DatabaseHandler.IMAGE_URL,images.url());
        values.put(DatabaseHandler.IMAGE_RELATION_ID,images.relation_id());
        values.put(DatabaseHandler.IMAGE_TYPE,images.type());

        db.insert(DatabaseHandler.TABLE_IMAGE,null,values);
        db.close();
    }
    public List<Images> getAllImages(int relation_id) {
        List<Images> images = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getReadableDatabase();


        String query = "SELECT * FROM " + DatabaseHandler.TABLE_IMAGE +
                " JOIN " + DatabaseHandler.TABLE_PRODUCT + " ON " + relation_id + " = " + DatabaseHandler.TABLE_PRODUCT + "." + DatabaseHandler.PRODUCT_ID +
                " WHERE " + DatabaseHandler.TABLE_IMAGE + "." + DatabaseHandler.IMAGE_TYPE + " = 'product'";


        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Images images1=new Images(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(5)
            );
            images.add(images1);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return images;
    }

}
