package com.example.talent_manager_client;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.talent_manager_client.File_Listview.File;
import com.example.talent_manager_client.File_Listview.FileDao;
import com.example.talent_manager_client.File_Listview.FileDatabase;

import java.util.List;

public class FileViewModel extends AndroidViewModel {
    private FileDao fileDao;
    private FileDatabase fileDatabase;
    private LiveData<List<File>>allFileLive = null;
    private LiveData<Integer> count;
    public FileViewModel(Application application) {
        super(application);

        fileDatabase = FileDatabase.getDatabase(application);
        //searchDatabase.getSearchDao().

        fileDao = fileDatabase.getFileDao();

        allFileLive = fileDao.GetAllWorks();

        count = fileDao.GetCount();
    }

    public LiveData<Integer> getCount() {
        return count;
    }

    public FileDatabase getFileDatabase() {
        return fileDatabase;
    }

    public void setFileDatabase(FileDatabase searchDatabase) {
        this.fileDatabase = searchDatabase;
    }

    public LiveData<List<File>> getAllFileLive() {
        return allFileLive;
    }

    public void setAllSearchLive(LiveData<List<File>> allFileLive) {
        this.allFileLive = allFileLive;
    }

    public FileDao getFileDao() {
        return fileDao;
    }

    public void setFileDao(FileDao searchDao) {
        this.fileDao = searchDao;
    }

    void insertFiles(File...files){
        new InsertAsyncTask(fileDao).execute(files);
    }
    void updateFiles(File...files){
        new UpdateAsyncTask(fileDao).execute(files);
    }
    void deleteFiles(File...files){
        new DeleteAsyncTask(fileDao).execute(files);
    }
    void deleteAllWorksFiles(){
        new DeleteAllAsyncTask(fileDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<File,Void,Void> {
        private FileDao fileDao;

        public InsertAsyncTask(FileDao fileDao) {
            this.fileDao = fileDao;
        }


        protected Void doInBackground(File... files) {
            fileDao.InsertWorks(files);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<File,Void,Void> {
        private FileDao fileDao;

        public UpdateAsyncTask(FileDao fileDao) {
            this.fileDao = fileDao;
        }


        protected Void doInBackground(File... files) {
            fileDao.UpdateWorks(files);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<File,Void,Void> {
        private FileDao fileDao;

        public DeleteAsyncTask(FileDao fileDao) {
            this.fileDao = fileDao;
        }


        protected Void doInBackground(File... files) {
            fileDao.DeleteWorks(files);
            return null;
        }
    }
/*
    static class GetAllWorksAsyncTask extends AsyncTask<Search,Void,Void> {
        private SearchDao searchDao;

        public GetAllWorksAsyncTask(SearchDao searchDao) {
            this.searchDao = searchDao;
        }

        @Override
        protected Void doInBackground(Search... searches) {
            return SearchDao.GetAllWorks(searches);
            //return null;
        }
    }*/

    static class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void> {
        private FileDao fileDao;

        public DeleteAllAsyncTask(FileDao fileDao) {
            this.fileDao = fileDao;
        }


        protected Void doInBackground(Void... voids) {
            fileDao.DeleteAll();
            return null;
        }
    }

    // TODO: Implement the ViewModel
}