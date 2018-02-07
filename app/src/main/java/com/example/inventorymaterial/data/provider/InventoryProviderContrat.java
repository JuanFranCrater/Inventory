package com.example.inventorymaterial.data.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.inventorymaterial.data.db.InventoryContract;

import java.net.URI;
import java.util.HashMap;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContrat {
    public static final String AUTHORITY="com.example.inventorymaterial";
    public static final Uri AUTHORITY_URI=Uri.parse("content://"+AUTHORITY);

    private InventoryProviderContrat()
    {

    }

    public static class Depedency implements BaseColumns{
        public static final String CONTENT_PATH="dependency";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(InventoryProviderContrat.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String IMAGENAME = "imageName";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION,
                IMAGENAME
        };
    }
    public static class Sector implements BaseColumns{
        public static final String CONTENT_PATH="sector";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(InventoryProviderContrat.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "name";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String DEPENDENCYID = "idDependency";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION,
                DEPENDENCYID
        };
    }
    public static class Tipo implements BaseColumns{
        public static final String CONTENT_PATH="tipo";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(InventoryProviderContrat.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "nombre";;
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME
        };
    }
    public static class Category implements BaseColumns{
        public static final String CONTENT_PATH="category";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(InventoryProviderContrat.AUTHORITY_URI,CONTENT_PATH);
        public static final String NAME = "nombre";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION
        };
    }
    public static class SubCategory implements BaseColumns {

        public static final String CONTENT_PATH = "subcategoria";
        public static final String NAME = "nombre";
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORYID = "categoryID";
        public static final String[] PROJECTION = new String[] {
                BaseColumns._ID,
                NAME,
                SHORTNAME,
                DESCRIPTION,
                CATEGORYID
        };
    }
    public static class Product implements BaseColumns {
        public static final String CONTENT_PATH="product";
        public static final Uri CONTENT_URI=Uri.withAppendedPath(InventoryProviderContrat.AUTHORITY_URI,CONTENT_PATH);
        public static final String SHORTNAME = "shortname";
        public static final String DESCRIPTION = "description";
        public static final String CATEGORYID = "category";
        public static final String CATEGORYNAME = "categoryName";
        public static final String MODELCODE = "modelcode";
        public static final String SUBCATEGORYID = "subcategory";
        public static final String SUBCATEGORYNAME = "subcategory";
        public static final String QUANTITY = "quantity";
        public static final String TIPOID = "type";
        public static final String TIPONAME = "typeName";
        public static final String SECTIONID = "section";
        public static final String SECTIONNAME = "sectionName";
        public static final String STATUS = "status";
        public static final String SERIAL = "serial";
        public static final String VALUE = "value";
        public static final String VENDOR = "vendor";
        public static final String URL = "url";
        public static final String DATEPURCHASE = "datepurchase";
        public static final String NOTES = "notes";
        private static final String BITMAP = "bitmap";
        private static final String IMAGEBASE64 = "imageBase64";
        private static final String IMAGENAME = "imageName";

        public static final String[] PROJECTION = new String[]{
                BaseColumns._ID, SERIAL, MODELCODE,
                SHORTNAME, DESCRIPTION, CATEGORYID, CATEGORYNAME,
                SUBCATEGORYID, SUBCATEGORYNAME, TIPOID, TIPONAME, SECTIONID,
                STATUS, QUANTITY, VALUE,
                VENDOR, BITMAP, IMAGEBASE64,
                IMAGENAME, URL, DATEPURCHASE,
                NOTES
        };

        public static HashMap<String, String> sProductInnerProjectionMap;

        static {
            sProductInnerProjectionMap= new HashMap<>();
            sProductInnerProjectionMap.put(_ID,Product.CONTENT_PATH+"."+Product._ID);
            sProductInnerProjectionMap.put(SERIAL,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_SERIAL);
            sProductInnerProjectionMap.put(MODELCODE,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_MODELCODE);
            sProductInnerProjectionMap.put(SHORTNAME,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_SHORTNAME);
            sProductInnerProjectionMap.put(DESCRIPTION,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(CATEGORYID,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_CATEGORYID);
            sProductInnerProjectionMap.put(CATEGORYNAME,Category.CONTENT_PATH+"."+Category.NAME);
            sProductInnerProjectionMap.put(SUBCATEGORYID,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_SUBCATEGORYID);
            sProductInnerProjectionMap.put(SUBCATEGORYNAME,SubCategory.CONTENT_PATH+"."+SubCategory.NAME);
            sProductInnerProjectionMap.put(TIPOID,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_TIPOID);
            sProductInnerProjectionMap.put(TIPONAME,Tipo.CONTENT_PATH+"."+Tipo.NAME);
            sProductInnerProjectionMap.put(SECTIONID,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_SECTIONID);
            sProductInnerProjectionMap.put(SECTIONNAME,Sector.CONTENT_PATH+"."+Sector.NAME);
            sProductInnerProjectionMap.put(STATUS,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_STATUS);
            sProductInnerProjectionMap.put(QUANTITY,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_QUANTITY);
            sProductInnerProjectionMap.put(VALUE,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_VALUE);
            sProductInnerProjectionMap.put(VENDOR,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_VENDOR);
            sProductInnerProjectionMap.put(BITMAP,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_BITMAP);
            sProductInnerProjectionMap.put(IMAGEBASE64,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_IMAGEBASE64);
            sProductInnerProjectionMap.put(IMAGENAME,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_IMAGENAME);
            sProductInnerProjectionMap.put(URL,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_URL);
            sProductInnerProjectionMap.put(DATEPURCHASE,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_DATEPURCHASE);
            sProductInnerProjectionMap.put(NOTES,InventoryContract.ProductJoinEntry.TABLE_NAME+"."+InventoryContract.ProductJoinEntry.COLUMN_NOTES);
        }
    }
}
