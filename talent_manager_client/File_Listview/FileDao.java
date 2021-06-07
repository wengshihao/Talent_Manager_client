package com.example.talent_manager_client.File_Listview;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FileDao {
    @Insert
    void InsertWorks(File... files);

    @Update
    void UpdateWorks(File... files);

    @Delete
    void DeleteWorks(File... files);

    @Query("Delete FROM File")
    void DeleteAll();

    @Query("SELECT * FROM File ORDER BY ID DESC")
    LiveData<List<File>> GetAllWorks();

    @Query("SELECT COUNT(*) FROM File")
    LiveData<Integer> GetCount();
}
