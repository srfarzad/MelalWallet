package com.navin.melalwallet.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.navin.melalwallet.models.Basket;
import com.navin.melalwallet.models.User;


@Database(entities = {User.class, Basket.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();

    private static AppDatabase instance=null;


    public static synchronized AppDatabase getInstance(Context context) {

        if(instance==null){

            instance = Room.databaseBuilder(context,
                    AppDatabase.class,"app")
                    .allowMainThreadQueries()
                    .build();


        }


        return  instance;

    }




}
