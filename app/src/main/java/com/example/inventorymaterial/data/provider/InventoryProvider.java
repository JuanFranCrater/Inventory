package com.example.inventorymaterial.data.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.inventorymaterial.data.db.InventoryContract;
import com.example.inventorymaterial.data.db.InventoryOpenHelper;

/**
 * Created by usuario on 5/02/18.
 */

public class InventoryProvider extends ContentProvider {

    private static final int PRODUCT=1;
    private static final int PRODUCT_ID=2;
    private static final int DEPENDENCY=3;
    private static final int DEPENDENCY_ID=4;
    private static final int SECTOR=5;
    private static final int SECTOR_ID=6;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH,PRODUCT);
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH+"/#",PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH,DEPENDENCY);
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH+"/#",DEPENDENCY_ID);
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH,SECTOR);
        uriMatcher.addURI(InventoryProviderContrat.AUTHORITY,InventoryProviderContrat.Product.CONTENT_PATH+"/#",SECTOR_ID);
    }

    private SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        sqLiteDatabase= InventoryOpenHelper.getInstance().openDateBase();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selectoin, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        Cursor cursor =null ;

        switch (uriMatcher.match(uri))
        {
            case PRODUCT:

                break;
            case PRODUCT_ID:
                break;
            case DEPENDENCY:
             cursor= sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME, projection, selectoin, selectionArgs, null,null,sortOrder);
                break;
            case DEPENDENCY_ID:

                break;
            case SECTOR:
                break;
            case SECTOR_ID:
                break;
            case UriMatcher.NO_MATCH:
                throw new IllegalArgumentException("Invalid Uri:"+uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
