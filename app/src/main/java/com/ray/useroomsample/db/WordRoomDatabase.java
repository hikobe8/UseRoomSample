package com.ray.useroomsample.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.ray.useroomsample.dao.WordDao;
import com.ray.useroomsample.entity.Word;

/**
 * Author : hikobe8@github.com
 * Time : 2018/8/13 下午10:49
 * Description :
 */
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static WordRoomDatabase sInstance;

    public static WordRoomDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (WordRoomDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return sInstance;
    }

    /*
     * just use for initialized data
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(sInstance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private WordDao mWordDao;

        PopulateDbAsync(WordRoomDatabase database) {
            mWordDao = database.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDao.insert(new Word("Hello"));
            mWordDao.insert(new Word("World"));
            return null;
        }
    }

}
