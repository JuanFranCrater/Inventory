package com.example.inventorymaterial.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.example.inventorymaterial.data.db.dao.daoInterface.daoDependencyInterface;
import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.provider.InventoryProviderContrat;
import com.example.inventorymaterial.ui.inventory.InventoryApplication;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDao implements daoDependencyInterface {

    @Override
    public ArrayList<Dependency> loadAll() {

        ArrayList<Dependency> list = new ArrayList<>();

        //1. Array projections (se puede igualar al projection de la clase, en vez de los campos, pero asi lo veremos en internet)
        String[] projections = new String[]{
                InventoryProviderContrat.Dependency._ID,
                InventoryProviderContrat.Dependency.NAME,
                InventoryProviderContrat.Dependency.SHORTNAME,
                InventoryProviderContrat.Dependency.DESCRIPTION,
                InventoryProviderContrat.Dependency.IMAGENAME
        };

        //2. Hago la consulta al provider con la uri de Dependency
        // Con content provider esta registrado en el sistema
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();//todos los content provider estan getionados por esto
        Cursor cursor = cr.query(
                InventoryProviderContrat.Dependency.CONTENT_URI,
                projections,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                list.add(new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            }while (cursor.moveToNext());
        }

        return list;
    }

    @Override
    public boolean contains(Dependency dependency) {
        return false;
    }

    @Override
    public int update(Dependency d) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        String where = InventoryProviderContrat.Dependency._ID +"=?";
        String[] whereArgs = new String[]{String.valueOf(d.get_ID())};
         int id = cr.update(
                 InventoryProviderContrat.Dependency.CONTENT_URI,
                 CreateContent(d),
                 where,
                  whereArgs
                 );
                return id;
    }

    @Override
    public long delete(Dependency d) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        String where = InventoryProviderContrat.Dependency._ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(d.get_ID())};
        int id = cr.delete(
                Uri.parse(InventoryProviderContrat.Dependency.CONTENT_URI+"/"+String.valueOf(d.get_ID())),
                null,
                null
        );
        return id;
    }

    @Override
    public ContentValues createContent(Dependency d) {
        return null;
    }

    @Override
    public boolean exists(Dependency d) {
        return false;
    }

    @Override
    public long save(Dependency d) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Uri uri = cr.insert(
                InventoryProviderContrat.Dependency.CONTENT_URI,
                CreateContent(d)
        );
        if (uri==null){
            return -1;
        }
        return Long.parseLong(uri.getLastPathSegment());
    }
    @Override
    public ContentValues CreateContent(Dependency dependency) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryProviderContrat.Dependency.NAME, dependency.getName());
        contentValues.put(InventoryProviderContrat.Dependency.SHORTNAME, dependency.getSortName());
        contentValues.put(InventoryProviderContrat.Dependency.DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryProviderContrat.Dependency.IMAGENAME, dependency.getImageName());
        return contentValues;
    }
}
