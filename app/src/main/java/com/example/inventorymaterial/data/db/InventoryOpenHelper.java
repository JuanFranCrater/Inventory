package com.example.inventorymaterial.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.inventorymaterial.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 19/01/18.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    private static InventoryOpenHelper singletone;
    private SQLiteDatabase sqLiteDatabase;

    public InventoryOpenHelper() {
        super(InventoryApplication.getContext(), InventoryContrat.DATABASE_NAME, null, InventoryContrat.DATABASE_VERSION);
    }

    public static InventoryOpenHelper getInstance()
    {
        if(singletone==null)
        {
            singletone=new InventoryOpenHelper();
        }
        return singletone;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(InventoryContrat.DependencyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContrat.DependencyEntry.SQL_INSERT_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContrat.SectorEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContrat.SectorEntry.SQL_INSERT_ENTRIES);
    }
    public void openDatabase()
    {
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly())
        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN)
            {
                db.setForeignKeyConstraintsEnabled(true);
            }else{
                //Android 3.0 no deja poner ON
                db.execSQL("PRAGMA foreign_keys=1");
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
