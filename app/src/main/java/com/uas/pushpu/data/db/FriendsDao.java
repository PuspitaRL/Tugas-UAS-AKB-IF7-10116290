package com.uas.pushpu.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.uas.pushpu.data.model.Friends;

import java.util.List;



@Dao
public interface FriendsDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addFriend(Friends... friends);

    @Delete
    void deleteFriend(Friends... friends);

    @Update
    void updateFriend(Friends... friends);

    @Query("SELECT * FROM friends ORDER BY nim")
    LiveData<List<Friends>> getAll();
}
