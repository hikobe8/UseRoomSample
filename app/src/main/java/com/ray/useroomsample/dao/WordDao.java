package com.ray.useroomsample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.ray.useroomsample.entity.Word;

import java.util.List;

/***
 *  Author : ryu18356@gmail.com
 *  Create at 2018-08-13 19:02
 *  description : 
 */
@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

}
