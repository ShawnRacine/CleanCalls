package com.racine.cleancalls.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Shawn Racine.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "harassment.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the FIRST time.
     * If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS CallBlocker" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, phone INTEGER, type INTEGER, date INTEGER, remark TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS SMSBlocker" +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, phone INTEGER, type INTEGER, date INTEGER, content TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("ALTER TABLE fy_house_history ADD COLUMN other STRING");
    }
}
