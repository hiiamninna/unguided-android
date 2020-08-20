package com.ninnanovila.datapersistent;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static DatabaseClient databaseClient;

    private AppDatabase database;

    private DatabaseClient(Context context){
        database = Room.databaseBuilder(context, AppDatabase.class, "employee").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (databaseClient==null){
            databaseClient = new DatabaseClient(context);
        }
        return databaseClient;
    }

    public AppDatabase getDatabase(){
        return database;
    }
}
