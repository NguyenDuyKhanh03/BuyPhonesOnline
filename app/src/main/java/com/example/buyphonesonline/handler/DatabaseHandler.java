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
    public static final String PRODUCT_DESCRIPTION = "description";
    public static final String PRODUCT_QUANTITY = "quantity";
    public static final String PRODUCT_CATEGORY_ID = "categoryId";
    public static final String PRODUCT_QUANTITY_SOLD = "quantitySold";

    //Bảng image

    public static final String TABLE_IMAGE = "Images";
    public static final String IMAGE_ID = "id";
    public static final String IMAGE_NAME = "name";
    public static final String IMAGE_URL = "url";
    public static final String IMAGE_RELATION_ID = "relation_id";
    public static final String IMAGE_TYPE = "type";


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
                    PRODUCT_DESCRIPTION + " TEXT NOT NULL, " +
                    PRODUCT_QUANTITY + " INTEGER NOT NULL, " +
                    PRODUCT_CATEGORY_ID + " INTEGER NOT NULL, " +
                    PRODUCT_QUANTITY_SOLD + " INTEGER NOT NULL, " +
                    "FOREIGN KEY(" + PRODUCT_CATEGORY_ID + ") REFERENCES " + TABLE_CATEGORY + "(" + CATEGORY_ID + "));";

    private static final String CREATE_TABLE_IMAGES =
            "CREATE TABLE IF NOT EXISTS " + TABLE_IMAGE + " (" +
                    IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    IMAGE_NAME + " TEXT, " +
                    IMAGE_URL + " TEXT, " +
                    IMAGE_RELATION_ID + " INTEGER, " +
                    IMAGE_TYPE + " TEXT" +
                    ")";

    private static DatabaseHandler databaseHandler=null;
    public static DatabaseHandler newInstance(Context context){
        if(databaseHandler==null){
            databaseHandler=new DatabaseHandler(context);
        }
        return databaseHandler;
    }
    public DatabaseHandler(@Nullable Context context) {
        super(context ,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(DATABASE_VERSION>2) {
            db.execSQL(CREATE_TABLE_CATEGORY);
            db.execSQL(CREATE_TABLE_PRODUCT);
            db.execSQL(CREATE_TABLE_IMAGES);
        }
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_PRODUCT);
        db.execSQL(CREATE_TABLE_IMAGES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(DATABASE_VERSION>2){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
            // Tạo lại bảng mới
            onCreate(db);
        }
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
        // Tạo lại bảng mới
        onCreate(db);
    }
}
