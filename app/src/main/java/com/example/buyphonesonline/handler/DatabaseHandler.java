package com.example.buyphonesonline.handler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QLCH";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_CATEGORY = "Category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";


    // Bảng Product
    public static final String TABLE_PRODUCT = "Product";
    public static final String PRODUCT_ID = "id";
    public static final String PRODUCT_IMAGE = "image";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_QUANTITY = "quantity";
    public static final String PRODUCT_CATEGORY_ID = "categoryId";
    public static final String PRODUCT_QUANTITY_SOLD = "quantitySold";


    private static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CATEGORY_NAME + " TEXT NOT NULL);";

    private static final String CREATE_TABLE_PRODUCT =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PRODUCT + " (" +
                    PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PRODUCT_IMAGE + " TEXT, " +
                    PRODUCT_NAME + " TEXT NOT NULL, " +
                    PRODUCT_PRICE + " REAL NOT NULL, " +
                    PRODUCT_QUANTITY + " INTEGER NOT NULL, " +
                    PRODUCT_CATEGORY_ID + " INTEGER NOT NULL, " +
                    PRODUCT_QUANTITY_SOLD + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + PRODUCT_CATEGORY_ID + ") REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_ID + "));";

    public DatabaseHandler(@Nullable Context context) {
        super(context ,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(DATABASE_VERSION>2) {
            db.execSQL(CREATE_TABLE_CATEGORY);
            db.execSQL(CREATE_TABLE_PRODUCT);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(DATABASE_VERSION>2){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
            // Tạo lại bảng mới
            onCreate(db);
        }

    }
}