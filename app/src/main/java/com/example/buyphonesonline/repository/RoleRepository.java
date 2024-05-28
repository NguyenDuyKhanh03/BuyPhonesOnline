package com.example.buyphonesonline.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.buyphonesonline.handler.DatabaseHandler;

public class RoleRepository {
    private final DatabaseHandler databaseHandler;

    public RoleRepository(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }

    public void addRole(String name){
        SQLiteDatabase db=databaseHandler.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHandler.COLUMN_ROLE_NAME,name);
        db.insert(DatabaseHandler.TABLE_ROLE,null,contentValues);
        db.close();
    }

    public int getRoleId(String name){
        int id=1;
        SQLiteDatabase db=databaseHandler.getReadableDatabase();
        String query="SELECT "+DatabaseHandler.COLUMN_ROLE_ID+" FROM "+DatabaseHandler.TABLE_ROLE+" WHERE "+DatabaseHandler.COLUMN_ROLE_NAME+" =?";
        Cursor cursor=db.rawQuery(query,new String[]{name});
        if(cursor!=null){
            if(cursor.moveToFirst()){
                id=cursor.getInt(0);
                db.close();
                cursor.close();
                return id;
            }
        }

        db.close();
        return id;
    }
}
