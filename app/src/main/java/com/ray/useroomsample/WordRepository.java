package com.ray.useroomsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.ray.useroomsample.dao.WordDao;
import com.ray.useroomsample.db.WordRoomDatabase;
import com.ray.useroomsample.entity.Word;

import java.util.List;

/**
 * Author : hikobe8@github.com
 * Time : 2018/8/13 下午10:58
 * Description :
 */
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase roomDatabase = WordRoomDatabase.getInstance(application);
        mWordDao = roomDatabase.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void inset(Word word) {
        new InsertAsyncTack(mWordDao).execute(word);
    }

    private static class InsertAsyncTack extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncWordDao;

        public InsertAsyncTack(WordDao asyncWordDao) {
            mAsyncWordDao = asyncWordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncWordDao.insert(words[0]);
            return null;
        }
    }

}
