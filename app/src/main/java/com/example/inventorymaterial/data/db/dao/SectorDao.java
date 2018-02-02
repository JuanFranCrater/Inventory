package com.example.inventorymaterial.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventorymaterial.data.db.InventoryContract;
import com.example.inventorymaterial.data.db.InventoryOpenHelper;
import com.example.inventorymaterial.data.db.model.Sector;

import java.util.ArrayList;

public class SectorDao {

    public ArrayList<Sector> loadAll () {
        ArrayList<Sector> sectores = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.SectorEntry.TABLE_NAME,
                InventoryContract.SectorEntry.ALL_COLUMN,
                null, null, null,null,
                null, null);

        if (cursor.moveToFirst()) {

            while (cursor.moveToNext()) {
                Sector s = new Sector(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getInt(4), false, false);
                sectores.add(s);
            }
        }

        sqLiteDatabase.close();

        return sectores;
    }

    public long save(Sector s) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();

        long filasAfectadas = sqLiteDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME,
                null, getContentValues(s));

        sqLiteDatabase.close();
        return filasAfectadas;
    }

    public long update(Sector s) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();

        long filasAfectadas = sqLiteDatabase.update(InventoryContract.SectorEntry.TABLE_NAME,
                getContentValues(s), BaseColumns._ID + "=" + s.getName(), null);

        sqLiteDatabase.close();
        return filasAfectadas;
    }

    public long delete(Sector s) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();

        long filasAfectadas = sqLiteDatabase.delete(InventoryContract.SectorEntry.TABLE_NAME,
                BaseColumns._ID + "=" + s.getName(), null);

        sqLiteDatabase.close();
        return filasAfectadas;
    }

    private ContentValues getContentValues(Sector s) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCYID, s.getDependencyId());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_NAME, s.getName());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME, s.getShortname());
        contentValues.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, s.getDescription());

        return contentValues;
    }

    public void add(Sector sector) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();

        ContentValues contentValues=getContentValues(sector);
        long solucion= sqLiteDatabase.insert(InventoryContract.SectorEntry.TABLE_NAME,null, contentValues);
        InventoryOpenHelper.getInstance().closeDateBase();

        sqLiteDatabase.close();
    }
}
