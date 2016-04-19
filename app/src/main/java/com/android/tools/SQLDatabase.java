package com.android.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import app.tools.database.SQLiteAssetHelper;

public class SQLDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "test.sqlite";
    private static final int DATABASE_VERSION = 1;

    public SQLDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade(DATABASE_VERSION);
    }

    public void setValue(double value) {
        double a = 9.99;

        Log.e(" * ", " * " + (a * 101));

        ContentValues contentValues = new ContentValues();
        contentValues.put("value", "a");

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insertOrThrow("number", null, contentValues);
    }
}
