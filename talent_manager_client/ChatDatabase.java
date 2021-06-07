package com.example.talent_manager_client;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Chat.class},version = 2,exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {
    private  static com.example.talent_manager_client.ChatDatabase INSTANCE;
    static com.example.talent_manager_client.ChatDatabase getDatabase(Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(), com.example.talent_manager_client.ChatDatabase.class,"chat_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    public abstract ChatDao getChatDao();
}
