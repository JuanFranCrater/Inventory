package com.example.inventorymaterial.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.inventorymaterial.data.db.InventoryContract;
import com.example.inventorymaterial.data.db.InventoryOpenHelper;
import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.data.db.model.ProductInner;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {

    public ProductInner search (int id)
    {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        SQLiteQueryBuilder sqLiteQueryBuilder=new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(InventoryContract.ProductJoinEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductJoinEntry.sProductInnerProjectionMap);
        //1VAmos a mostrar si la consulta es correcta
       String sql = sqLiteQueryBuilder.buildQuery(InventoryContract.ProductJoinEntry.ALL_COLUMNS,null,null,
               null,null,null);

        String selection = InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry._ID+"=?";
        String[] selectionArgs = {id+""};

        Cursor cursor=sqLiteQueryBuilder.query(sqLiteDatabase,InventoryContract.ProductJoinEntry.ALL_COLUMNS,selection,selectionArgs,null,null,null);
        if (cursor.moveToFirst()) {
                ProductInner s = new ProductInner(cursor.getInt(0),
                        cursor.getString(1),cursor.getString(1),
                        cursor.getString(3),cursor.getString(4),
                        cursor.getInt(5),cursor.getString(6),
                        cursor.getInt(7),cursor.getInt(8),
                        cursor.getString(9),cursor.getInt(10),
                        cursor.getString(11),cursor.getInt(12),
                        cursor.getInt(13), cursor.getDouble(14),
                        cursor.getString(15), cursor.getString(16),
                        cursor.getString(17), cursor.getString(18),
                        cursor.getString(19),cursor.getString(20),
                        cursor.getString(21));
            sqLiteDatabase.close();
            return s;
        }
        cursor.close();
        sqLiteDatabase.close();
       return null;

    }

    public ArrayList<Product> loadAll () {

        ArrayList<Product> products = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null,null,
                BaseColumns._ID, null);
            products.clear();
        if (cursor.moveToFirst()) {
            Log.d("Cursor Inicio", String.valueOf(products.size()));
            do{
                    Product s = new Product(cursor.getInt(0),
                            cursor.getString(1),cursor.getString(1),
                            cursor.getString(3),cursor.getString(4),
                            cursor.getInt(5),cursor.getInt(6),
                            cursor.getInt(7),cursor.getInt(8),
                            cursor.getInt(9),cursor.getInt(10),
                            cursor.getDouble(11),cursor.getString(12),
                            cursor.getString(13), cursor.getString(14),
                            cursor.getString(15), cursor.getString(16),
                            cursor.getString(17), cursor.getString(18));
                products.add(s);
                Log.d("Cursor Final", String.valueOf(products.size()));
            }while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return products;
    }
}
