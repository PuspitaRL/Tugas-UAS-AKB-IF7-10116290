package com.uas.pushpu.data.db;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.uas.pushpu.data.model.Friends;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class FriendsDao_Impl implements FriendsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfFriends;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfFriends;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfFriends;

  public FriendsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFriends = new EntityInsertionAdapter<Friends>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR FAIL INTO `friends`(`nim`,`name`,`class_`,`phone`,`email`,`ig`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Friends value) {
        if (value.getNim() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNim());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getClass_() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClass_());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEmail());
        }
        if (value.getIg() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIg());
        }
      }
    };
    this.__deletionAdapterOfFriends = new EntityDeletionOrUpdateAdapter<Friends>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `friends` WHERE `nim` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Friends value) {
        if (value.getNim() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNim());
        }
      }
    };
    this.__updateAdapterOfFriends = new EntityDeletionOrUpdateAdapter<Friends>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `friends` SET `nim` = ?,`name` = ?,`class_` = ?,`phone` = ?,`email` = ?,`ig` = ? WHERE `nim` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Friends value) {
        if (value.getNim() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getNim());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getClass_() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClass_());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhone());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEmail());
        }
        if (value.getIg() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIg());
        }
        if (value.getNim() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNim());
        }
      }
    };
  }

  @Override
  public void addFriend(Friends... friends) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfFriends.insert(friends);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteFriend(Friends... friends) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfFriends.handleMultiple(friends);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateFriend(Friends... friends) {
    __db.beginTransaction();
    try {
      __updateAdapterOfFriends.handleMultiple(friends);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Friends>> getAll() {
    final String _sql = "SELECT * FROM friends ORDER BY nim";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Friends>>() {
      private Observer _observer;

      @Override
      protected List<Friends> compute() {
        if (_observer == null) {
          _observer = new Observer("friends") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfNim = _cursor.getColumnIndexOrThrow("nim");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfClass = _cursor.getColumnIndexOrThrow("class_");
          final int _cursorIndexOfPhone = _cursor.getColumnIndexOrThrow("phone");
          final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
          final int _cursorIndexOfIg = _cursor.getColumnIndexOrThrow("ig");
          final List<Friends> _result = new ArrayList<Friends>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Friends _item;
            final String _tmpNim;
            _tmpNim = _cursor.getString(_cursorIndexOfNim);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpClass_;
            _tmpClass_ = _cursor.getString(_cursorIndexOfClass);
            final String _tmpPhone;
            _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpIg;
            _tmpIg = _cursor.getString(_cursorIndexOfIg);
            _item = new Friends(_tmpName,_tmpNim,_tmpClass_,_tmpPhone,_tmpEmail,_tmpIg);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
