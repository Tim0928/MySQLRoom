package com.avc.app.mysqlroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities ={Book.class},version = 2)//entities means table
public abstract class MyAppDatabase extends RoomDatabase {
//    private static  MyAppDatabase instance;//instance詳細 實體
    public  abstract MyDao myDao();
//    //synchronized 同步
//    public  static synchronized MyAppDatabase getInstance(Context context){
//        if(instance==null){
//            instance= Room.databaseBuilder(context.getApplicationContext(),
//                    MyAppDatabase.class,"my_database")
//                    .fallbackToDestructiveMigration()
//                    .build();
//
//        }
//        return  instance;
//    }
}
