package com.example.inventorymaterial.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.provider.BaseColumns;
import com.example.inventorymaterial.data.db.InventoryContract;
import com.example.inventorymaterial.data.db.InventoryOpenHelper;
import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;


public class DependencyDao {


    public ArrayList<Dependency> loadAll()
    {
        final ArrayList<Dependency> dependencies=new ArrayList<>();
        final boolean[] wait = {true};
        final SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
                Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                        InventoryContract.DependencyEntry.ALL_COLUMN,
                        null,
                        null,
                        null,
                        null,
                        InventoryContract.DependencyEntry.DEFAULT_SORT,
                        null);
                if(cursor.moveToFirst())
                {
                    do{
                        Dependency dependency=new Dependency(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                        dependencies.add(dependency);
                    }while (cursor.moveToNext());
                }
            InventoryOpenHelper.getInstance().closeDateBase();
        return dependencies;
    }

    public boolean contains(Dependency dependency)
    {
        return false;
    }


    public int update(Dependency d) {
        SQLiteDatabase sqLiteDatabase=InventoryOpenHelper.getInstance().openDateBase();
        ContentValues contentValues=createContent(d);
        String where=BaseColumns._ID+"=?";
        String[] whereArgs= new String[]{String.valueOf(d.get_ID())};
        int solucion= sqLiteDatabase.update(InventoryContract.DependencyEntry.TABLE_NAME,contentValues,where ,whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return solucion;
    }

    public long delete(Dependency d) {
        SQLiteDatabase sqLiteDatabase=InventoryOpenHelper.getInstance().openDateBase();
        String where=BaseColumns._ID+"=?";
        String[] whereArgs= new String[]{String.valueOf(d.get_ID())};
        long solucion= sqLiteDatabase.delete(InventoryContract.DependencyEntry.TABLE_NAME,where,whereArgs);
        InventoryOpenHelper.getInstance().closeDateBase();
        return solucion;
    }
    public ContentValues createContent(Dependency d)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME,d.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME,d.getSortName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION,d.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME,d.getImageName());
        return contentValues;
    }
    public boolean exists(Dependency d) {
        return false;

    }

    public void save(String name, String shortName, String description, String imageName) {
        SQLiteDatabase sqLiteDatabase=InventoryOpenHelper.getInstance().openDateBase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME,name);
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME,shortName);
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION,description);
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME,imageName);
        long solucion= sqLiteDatabase.insert(InventoryContract.DependencyEntry.TABLE_NAME,null, contentValues);
        InventoryOpenHelper.getInstance().closeDateBase();
    }

}