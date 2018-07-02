package com.phantom.asalama.art.contentProvider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.phantom.asalama.art.contentProvider.Contract;
import com.phantom.asalama.art.contentProvider.DBHelper;

import static com.phantom.asalama.art.contentProvider.Contract.AUTHORITY;
import static com.phantom.asalama.art.contentProvider.Contract.BASE_PATH;
import static com.phantom.asalama.art.contentProvider.DBHelper.TABLE_ART;

public class ContentProvider extends android.content.ContentProvider {

    public static final int ARTS=100;
    public static final int ART_WITH_ID=101;

    private static final UriMatcher sUriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(AUTHORITY,BASE_PATH,ARTS);
        sUriMatcher.addURI(AUTHORITY,BASE_PATH + "/#",ART_WITH_ID);
    }

    private DBHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper=new DBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db=mDbHelper.getReadableDatabase();
        Cursor retCursor;

        switch (sUriMatcher.match(uri)){
            case ARTS:
                SQLiteQueryBuilder queryBuilder=new SQLiteQueryBuilder();
                queryBuilder.setTables(TABLE_ART);
                retCursor=queryBuilder.query(db,projection,selection,
                        selectionArgs,null,null,sortOrder);
                break;

             default:
                 throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
            final  SQLiteDatabase db=mDbHelper.getWritableDatabase();
            Uri retUri;
            switch (sUriMatcher.match(uri)){
                case ARTS:
                    long id =db.insert(TABLE_ART,null,values);
                    if(id>0)
                        retUri= ContentUris.withAppendedId(Contract.CONTEN_BASE_URI,id);
                    else
                        throw new android.database.SQLException("Failed to insert row into " + uri);

                    break;
                default:
                    throw new UnsupportedOperationException("Unknown uri: " + uri);

            }

            getContext().getContentResolver().notifyChange(uri,null);
        return retUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {

        SQLiteDatabase db= mDbHelper.getWritableDatabase();
        int deletedRows;
        deletedRows=db.delete(TABLE_ART,selection,selectionArgs);

        getContext().getContentResolver().notifyChange(uri,null);

        return deletedRows;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

        SQLiteDatabase db=mDbHelper.getWritableDatabase();

        int updatedRows;
        updatedRows=db.update(TABLE_ART,values,selection,selectionArgs);

        getContext().getContentResolver().notifyChange(uri,null);

        return updatedRows;
    }
}
