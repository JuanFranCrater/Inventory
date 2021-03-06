package com.example.inventorymaterial.data.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.inventorymaterial.ui.inventory.InventoryApplication;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    // volatile, no copies a los hilos si debe ser la misma copia para todos los thread
    private volatile static InventoryOpenHelper singleton;
    private SQLiteDatabase sqLiteDatabase;
    private AtomicInteger openCounter = new AtomicInteger();

    public InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME, null, InventoryContract.DATABASE_VERSION);
    }

    public synchronized static InventoryOpenHelper getInstance() {
        if (singleton==null) {
            singleton = new InventoryOpenHelper();
        }
        return singleton;
    }

    /**
     * Nos permitira realizar las operaciones con la base de datos
     * @return
     */
    public synchronized SQLiteDatabase openDateBase(){
        if (openCounter.incrementAndGet() == 1) {
            sqLiteDatabase = getWritableDatabase();
        }
        return sqLiteDatabase;
    }

    public synchronized  void closeDateBase(){
        if (openCounter.decrementAndGet()==0){
            sqLiteDatabase.close();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.beginTransaction();
            sqLiteDatabase.execSQL(InventoryContract.TipoEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.TipoEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.CategoryEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.CategoryEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SubCategoryEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SubCategoryEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.ProductEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.ProductEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
            sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
            sqLiteDatabase.setTransactionSuccessful();
        }catch (SQLiteException e)
        {
            Log.d("Error", e.getMessage());
        }finally {
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
            db.beginTransaction();
            db.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.CategoryEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.SubCategoryEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.TipoEntry.SQL_DELETE_ENTRIES);
            db.execSQL(InventoryContract.ProductJoinEntry.SQL_DELETE_ENTRIES);
            onCreate(db);
            db.setTransactionSuccessful();
        }catch (SQLiteException e)
        {

        }finally {
            db.endTransaction();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=1");
            }
        }
    }
}
