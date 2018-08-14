package com.ray.useroomsample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.ray.useroomsample.WordRepository;
import com.ray.useroomsample.entity.Word;

import java.util.List;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-08-14 9:42
 *  description : 
 */
public class WordViewModel extends AndroidViewModel {

    private WordRepository mWordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mWordRepository.inset(word);
    }

}
