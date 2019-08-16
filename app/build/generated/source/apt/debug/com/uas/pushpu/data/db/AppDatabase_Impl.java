package com.uas.pushpu.data.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile FriendsDao _friendsDao;

  private volatile UserDao _userDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `friends` (`nim` TEXT NOT NULL, `name` TEXT, `class_` TEXT, `phone` TEXT, `email` TEXT, `ig` TEXT, PRIMARY KEY(`nim`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`username` TEXT NOT NULL, `nane` TEXT, `password` TEXT, PRIMARY KEY(`username`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9c10f7baa4465c13c4c19d5032d9852e\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `friends`");
        _db.execSQL("DROP TABLE IF EXISTS `user`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFriends = new HashMap<String, TableInfo.Column>(6);
        _columnsFriends.put("nim", new TableInfo.Column("nim", "TEXT", true, 1));
        _columnsFriends.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsFriends.put("class_", new TableInfo.Column("class_", "TEXT", false, 0));
        _columnsFriends.put("phone", new TableInfo.Column("phone", "TEXT", false, 0));
        _columnsFriends.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsFriends.put("ig", new TableInfo.Column("ig", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFriends = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFriends = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFriends = new TableInfo("friends", _columnsFriends, _foreignKeysFriends, _indicesFriends);
        final TableInfo _existingFriends = TableInfo.read(_db, "friends");
        if (! _infoFriends.equals(_existingFriends)) {
          throw new IllegalStateException("Migration didn't properly handle friends(com.uas.pushpu.data.model.Friends).\n"
                  + " Expected:\n" + _infoFriends + "\n"
                  + " Found:\n" + _existingFriends);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(3);
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", true, 1));
        _columnsUser.put("nane", new TableInfo.Column("nane", "TEXT", false, 0));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          throw new IllegalStateException("Migration didn't properly handle user(com.uas.pushpu.data.model.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
      }
    }, "9c10f7baa4465c13c4c19d5032d9852e", "b90e725ddc3bd57fe5e3bcc44dd27526");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "friends","user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `friends`");
      _db.execSQL("DELETE FROM `user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public FriendsDao friendsDao() {
    if (_friendsDao != null) {
      return _friendsDao;
    } else {
      synchronized(this) {
        if(_friendsDao == null) {
          _friendsDao = new FriendsDao_Impl(this);
        }
        return _friendsDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
