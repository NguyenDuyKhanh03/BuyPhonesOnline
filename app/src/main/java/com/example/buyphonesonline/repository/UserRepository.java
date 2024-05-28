package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.buyphonesonline.handler.DatabaseHandler;
import com.example.buyphonesonline.models.User;

public class UserRepository {
    private DatabaseHandler databaseHandler;

    public UserRepository(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public long RegisterUser(User user){
        SQLiteDatabase db=databaseHandler.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHandler.COLUMN_USERNAME,user.username());
        values.put(DatabaseHandler.COLUMN_EMAIL,user.email());
        values.put(DatabaseHandler.COLUMN_PASSWORD,user.password());
        long result=db.insert(DatabaseHandler.TABLE_USER,null,values);
        if(result==-1)
            Log.e("DatabaseHandler", "Thêm user không thành công");
        else
            Log.i("DatabaseHandler", "User đã được thêm với ID : " + result);
        db.close();
        return result;
    }

    public int LoginUser(String username,String password){
        SQLiteDatabase db=databaseHandler.getReadableDatabase();
        String query="SELECT *FROM "+DatabaseHandler.TABLE_USER+" WHERE "+DatabaseHandler.COLUMN_CART_USERNAME+"=? AND "+DatabaseHandler.COLUMN_PASSWORD+"= ?";
        Cursor cursor= db.rawQuery(query,new String[]{username,password});
        int role=-1;
        if(cursor!=null){
            if(cursor.moveToFirst()){
                role=cursor.getInt(5);
            }
            cursor.close();
        }
        db.close();
        return role;
    }

}
