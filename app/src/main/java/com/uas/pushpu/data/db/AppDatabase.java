package com.uas.pushpu.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.uas.pushpu.data.model.Friends;
import com.uas.pushpu.data.model.User;



@Database(entities = {Friends.class, User.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract FriendsDao friendsDao();

    public abstract UserDao userDao();
}
