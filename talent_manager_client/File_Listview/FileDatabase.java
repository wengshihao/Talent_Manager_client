package com.example.talent_manager_client.File_Listview;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {File.class},version = 2,exportSchema = false)
public abstract class FileDatabase extends RoomDatabase {

    private static FileDatabase INSTANCE;
    public static synchronized FileDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FileDatabase.class,"file_database")
                    .build();
        }
        return INSTANCE;
    }
    public abstract FileDao getFileDao();

}
