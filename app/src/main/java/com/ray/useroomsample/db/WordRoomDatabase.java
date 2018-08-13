package com.ray.useroomsample.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ray.useroomsample.dao.WordDao;
import com.ray.useroomsample.entity.Word;

/**
 * Author : hikobe8@github.com
 * Time : 2018/8/13 下午10:49
 * Description :
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao wordDao();

    private static WordRoomDatabase sInstance;

    public static WordRoomDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (WordRoomDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").build();
                }
            }
        }
        return sInstance;
    }

}
