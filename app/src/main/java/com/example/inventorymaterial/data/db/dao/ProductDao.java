package com.example.inventorymaterial.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.inventorymaterial.data.db.InventoryContract;
import com.example.inventorymaterial.data.db.InventoryOpenHelper;
import com.example.inventorymaterial.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDao {
    public ArrayList<Product> loadAll () {
        ArrayList<Product> products = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null,null,
                null, null);

        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
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
            }
        }

        sqLiteDatabase.close();
        Log.d("Prueba", String.valueOf(products.size()));
        return products;
    }
}
