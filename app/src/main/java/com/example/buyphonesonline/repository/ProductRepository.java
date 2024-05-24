package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    DatabaseHandler databaseHandler;

    public ProductRepository(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public void addProduct(Product product){
        SQLiteDatabase db=databaseHandler.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(DatabaseHandler.CATEGORY_NAME,product.getName());
        values.put(DatabaseHandler.PRODUCT_QUANTITY,product.getQuantity());
        values.put(DatabaseHandler.PRODUCT_PRICE,product.getPrice());
        values.put(DatabaseHandler.PRODUCT_DESCRIPTION,product.description());
        values.put(DatabaseHandler.PRODUCT_IMAGE,product.getImage());
        values.put(DatabaseHandler.PRODUCT_CATEGORY_ID,product.getCategoryId());
        values.put(DatabaseHandler.PRODUCT_QUANTITY_SOLD,0);
        db.insert(DatabaseHandler.TABLE_PRODUCT,null,values);
        db.close();
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        String query="Select * from "+DatabaseHandler.TABLE_PRODUCT;
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Product product=new Product(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6),
                    cursor.getInt(7)
            );
            products.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return products;
    }
    public Product getProductByName(String name) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        String[] projection = {
                DatabaseHandler.PRODUCT_ID,
                DatabaseHandler.PRODUCT_IMAGE,
                DatabaseHandler.PRODUCT_NAME,
                DatabaseHandler.PRODUCT_PRICE,
                DatabaseHandler.PRODUCT_DESCRIPTION,
                DatabaseHandler.PRODUCT_QUANTITY,
                DatabaseHandler.PRODUCT_CATEGORY_ID,
                DatabaseHandler.PRODUCT_QUANTITY_SOLD
        };

        String selection = DatabaseHandler.PRODUCT_NAME+ " = ?";
        String[] selectionArgs = { String.valueOf(name) };

        Cursor cursor = db.query(DatabaseHandler.TABLE_PRODUCT, projection, selection, selectionArgs, null, null, null);

        Product product = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int id=cursor.getInt(0);
                String image = cursor.getString(1);
                double price = cursor.getDouble(3);
                String des = cursor.getString(4);
                int quantity = cursor.getInt(5);
                int categoryId = cursor.getInt(6);
                int quantitySold = cursor.getInt(7);

                product = new Product(id, image, name, price,des, quantity, categoryId, quantitySold);
            }
            cursor.close();
        }

        db.close();
        return product;
    }

    public Product getProductById(int id) {
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        String[] projection = {
                DatabaseHandler.PRODUCT_ID,
                DatabaseHandler.PRODUCT_IMAGE,
                DatabaseHandler.PRODUCT_NAME,
                DatabaseHandler.PRODUCT_PRICE,
                DatabaseHandler.PRODUCT_DESCRIPTION,
                DatabaseHandler.PRODUCT_QUANTITY,
                DatabaseHandler.PRODUCT_CATEGORY_ID,
                DatabaseHandler.PRODUCT_QUANTITY_SOLD
        };

        String selection = DatabaseHandler.PRODUCT_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query(DatabaseHandler.TABLE_PRODUCT, projection, selection, selectionArgs, null, null, null);

        Product product = null;
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String image = cursor.getString(1);
                String name=cursor.getString(2);
                double price = cursor.getDouble(3);
                String des = cursor.getString(4);
                int quantity = cursor.getInt(5);
                int categoryId = cursor.getInt(6);
                int quantitySold = cursor.getInt(7);

                product = new Product(id, image, name, price,des, quantity, categoryId, quantitySold);
            }
            cursor.close();
        }

//        db.close();
        return product;
    }
    public List<Product> getProductsByType(int productType) {
        List<Product> products = new ArrayList<>();
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        String query = "SELECT * FROM " + DatabaseHandler.TABLE_PRODUCT +
                " WHERE "+DatabaseHandler.TABLE_PRODUCT + "." + DatabaseHandler.PRODUCT_CATEGORY_ID + " = "+productType;
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Product product=new Product(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getInt(6),
                    cursor.getInt(7)
            );
            products.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return products;
    }

}
