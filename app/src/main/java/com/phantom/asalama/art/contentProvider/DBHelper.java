package com.phantom.asalama.art.contentProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.phantom.asalama.art.contentProvider.Contract.ArtEntry.*;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="artDB";
    public static final String TABLE_ART="artDetails";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ART_TABLE= "CREATE TABLE " + TABLE_ART + "("
                + COLUMN_NAME_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME_NAME + " TEXT,"
                + COLUMN_NAME_OWNER_DISPLAYED_NAME + " TEXT,"
                + COLUMN_NAME_COVER + " TEXT,"
                + COLUMN_NAME_FIELDS + " TEXT,"
                + COLUMN_NAME_APPRECIATIONS + " INTEGER,"
                + COLUMN_NAME_VIEWS + " INTEGER,"
                + COLUMN_NAME_DESCRIPTION + " TEXT,"
                + COLUMN_NAME_PUBLISHED_ON + " TEXT"
                + ")";
        db.execSQL(CREATE_ART_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ART);
        onCreate(db);
    }
}
