package com.example.lichi.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**db初始化一次
 */
public class MySqliteHelper extends SQLiteOpenHelper {
    public MySqliteHelper(Context context) {
        super(context, "person.db", null, 3);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person (personid integer primary key autoincrement, name varchar(20),sex varchar(20))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE person ADD age integer");
    }
}
