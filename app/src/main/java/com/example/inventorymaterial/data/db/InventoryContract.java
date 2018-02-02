package com.example.inventorymaterial.data.db;

import android.provider.BaseColumns;
import android.speech.SpeechRecognizer;

import com.example.inventorymaterial.data.db.model.Product;

import java.net.PortUnreachableException;
import java.util.HashMap;

/**
 * Created by usuario on 19/01/18.
 */

public final class InventoryContract {

    // la clase no se puede instanciar
    private InventoryContract(){

    }

    public static final int DATABASE_VERSION=13;
    public static final String DATABASE_NAME="Inventory.db";

    public static class ProductJoinEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORYID = "category";
        public static final String COLUMN_CATEGORYNAME = "categoryName";
        public static final String COLUMN_MODELCODE = "modelcode";
        public static final String COLUMN_SUBCATEGORY = "subcategory";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_TIPOID = "type";
        public static final String COLUMN_TIPONAME = "typeName";
        public static final String COLUMN_SECTIONID = "section";
        public static final String COLUMN_SECTIONNAME="sectionName";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATEPURCHASE = "datepurchase";
        public static final String COLUMN_NOTES = "notes";
        private static final String COLUMN_BITMAP = "bitmap";
        private static final String COLUMN_IMAGEBASE64 = "imageBase64";
        private static final String COLUMN_IMAGENAME = "imageName";

        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID, COLUMN_SERIAL, COLUMN_MODELCODE,
                COLUMN_SHORTNAME, COLUMN_DESCRIPTION,COLUMN_CATEGORYID,COLUMN_CATEGORYNAME,
                COLUMN_SUBCATEGORY,COLUMN_TIPOID,COLUMN_TIPONAME,COLUMN_SECTIONID,
                COLUMN_STATUS,COLUMN_QUANTITY,COLUMN_VALUE,
                COLUMN_VENDOR,COLUMN_BITMAP,COLUMN_IMAGEBASE64,
                COLUMN_IMAGENAME,COLUMN_URL,COLUMN_DATEPURCHASE,
                COLUMN_NOTES
        };


        public static final String PRODUCT_INNER =String.format("%s INNER JOIN %s ON %s=%s.%s ",ProductEntry.TABLE_NAME, CategoryEntry.TABLE_NAME, COLUMN_CATEGORYID,CategoryEntry.TABLE_NAME,CategoryEntry._ID)
                +String.format("INNER JOIN %s ON %s=%s.%s ", TipoEntry.TABLE_NAME, ProductEntry.COLUMN_TIPOID, TipoEntry.TABLE_NAME,TipoEntry._ID)
                +String.format("INNER JOIN %s ON %s=%s.%s ", SectorEntry.TABLE_NAME, ProductEntry.COLUMN_TIPOID, SectorEntry.TABLE_NAME,SectorEntry._ID);

        public static HashMap<String, String> sProductInnerProjectionMap;

        static {
            sProductInnerProjectionMap= new HashMap<>();
            sProductInnerProjectionMap.put(ProductEntry._ID,ProductEntry.TABLE_NAME+"."+ProductEntry._ID);
            sProductInnerProjectionMap.put(COLUMN_SERIAL,COLUMN_SERIAL);
            sProductInnerProjectionMap.put(COLUMN_MODELCODE,COLUMN_MODELCODE);
            sProductInnerProjectionMap.put(COLUMN_SHORTNAME,ProductJoinEntry.TABLE_NAME+"."+ProductJoinEntry.COLUMN_SHORTNAME);
            sProductInnerProjectionMap.put(COLUMN_DESCRIPTION,ProductJoinEntry.TABLE_NAME+"."+ProductJoinEntry.COLUMN_DESCRIPTION);
            sProductInnerProjectionMap.put(COLUMN_CATEGORYID,COLUMN_CATEGORYID);
            sProductInnerProjectionMap.put(COLUMN_CATEGORYNAME,CategoryEntry.TABLE_NAME+"."+CategoryEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_SUBCATEGORY,COLUMN_SUBCATEGORY);
            sProductInnerProjectionMap.put(COLUMN_TIPOID,COLUMN_TIPOID);
            sProductInnerProjectionMap.put(COLUMN_TIPONAME,TipoEntry.TABLE_NAME+"."+TipoEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_SECTIONID,COLUMN_SECTIONID);
            sProductInnerProjectionMap.put(COLUMN_SECTIONNAME,SectorEntry.TABLE_NAME+"."+SectorEntry.COLUMN_NAME);
            sProductInnerProjectionMap.put(COLUMN_STATUS,COLUMN_STATUS);
            sProductInnerProjectionMap.put(COLUMN_QUANTITY,COLUMN_QUANTITY);
            sProductInnerProjectionMap.put(COLUMN_VALUE,COLUMN_VALUE);
            sProductInnerProjectionMap.put(COLUMN_VENDOR,COLUMN_VENDOR);
            sProductInnerProjectionMap.put(COLUMN_BITMAP,COLUMN_BITMAP);
            sProductInnerProjectionMap.put(COLUMN_IMAGEBASE64,COLUMN_IMAGEBASE64);
            sProductInnerProjectionMap.put(COLUMN_IMAGENAME,COLUMN_IMAGENAME);
            sProductInnerProjectionMap.put(COLUMN_URL,COLUMN_URL);
            sProductInnerProjectionMap.put(COLUMN_DATEPURCHASE,COLUMN_DATEPURCHASE);
            sProductInnerProjectionMap.put(COLUMN_NOTES,COLUMN_NOTES);
        }

    }


    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "product";

        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORYID = "category";
        public static final String COLUMN_MODELCODE = "modelcode";
        public static final String COLUMN_SUBCATEGORY = "subcategory";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_TIPOID = "type";
        public static final String COLUMN_SECTIONID = "section";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATEPURCHASE = "datepurchase";
        public static final String COLUMN_NOTES = "notes";

        private static final String COLUMN_BITMAP = "bitmap";
        private static final String COLUMN_IMAGEBASE64 = "imageBase64";
        private static final String COLUMN_IMAGENAME = "imageName";

        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID, COLUMN_SERIAL, COLUMN_MODELCODE,
                COLUMN_SHORTNAME, COLUMN_DESCRIPTION,COLUMN_CATEGORYID,
                COLUMN_SUBCATEGORY,COLUMN_TIPOID,COLUMN_SECTIONID,
                COLUMN_STATUS,COLUMN_QUANTITY,COLUMN_VALUE,
                COLUMN_VENDOR,COLUMN_BITMAP,COLUMN_IMAGEBASE64,
                COLUMN_IMAGENAME,COLUMN_URL,COLUMN_DATEPURCHASE,
                COLUMN_NOTES
        };

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, " +

                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, "+

                        "%s REAL NOT NULL, "

                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL, "
                        + "%s TEXT NOT NULL) ",

                TABLE_NAME,
                BaseColumns._ID,

                COLUMN_SERIAL,//text
                COLUMN_MODELCODE,//text
                COLUMN_SHORTNAME,//text
                COLUMN_DESCRIPTION,//text

                COLUMN_CATEGORYID,//int
                COLUMN_SUBCATEGORY,//int
                COLUMN_TIPOID,//int
                COLUMN_SECTIONID,//int
                COLUMN_STATUS,//int
                COLUMN_QUANTITY,//int

                COLUMN_VALUE,//double

                COLUMN_VENDOR,//string
                COLUMN_BITMAP,//string
                COLUMN_IMAGEBASE64,//string
                COLUMN_IMAGENAME,//string
                COLUMN_URL,//string
                COLUMN_DATEPURCHASE,//string
                COLUMN_NOTES//string
                )
                ;

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s, %s, %s,%s, %s, %s) VALUES ('%s', '%s', '%s', '%s', %s,%s, %s, %s, %s, %s,%s, '%s', '%s', '%s', '%s','%s', '%s', '%s')",
                TABLE_NAME,
                COLUMN_SERIAL,//text
                COLUMN_MODELCODE,//text
                COLUMN_SHORTNAME,//text
                COLUMN_DESCRIPTION,//text

                COLUMN_CATEGORYID,//int
                COLUMN_SUBCATEGORY,//int
                COLUMN_TIPOID,//int
                COLUMN_SECTIONID,//int
                COLUMN_STATUS,//int
                COLUMN_QUANTITY,//int

                COLUMN_VALUE,//double

                COLUMN_VENDOR,//string
                COLUMN_BITMAP,//string
                COLUMN_IMAGEBASE64,//string
                COLUMN_IMAGENAME,//string
                COLUMN_URL,//string
                COLUMN_DATEPURCHASE,//string
                COLUMN_NOTES,//string

                "1", "1", "ProductoA", "Description", "1","1", "1", "1", "1","1", "1", "1", "1","1", "1", "1", "1","1", "1");

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);

    }

    public static class CategoryEntry implements BaseColumns {

        public static final String TABLE_NAME = "categoria";
        public static final String COLUMN_NAME = "nombre";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " + "%s TEXT NOT NULL"+ "%s TEXT NOT NULL"+ "%s TEXT NOT NULL)", TABLE_NAME, BaseColumns._ID, COLUMN_NAME,COLUMN_SHORTNAME,COLUMN_DESCRIPTION);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s) VALUES ('%s','%s','%s'), ('%s','%s','%s'), ('%s','%s','%s')", TABLE_NAME, COLUMN_NAME, "CategoríaA","CA","Description", "CategoríaB","CB","Description", "CategoríaC","CC","Description");

    }

    public static class TipoEntry implements BaseColumns {

        public static final String TABLE_NAME = "type";
        public static final String COLUMN_NAME = "nombre";

        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s) VALUES ('%s'), ('%s'), ('%s')",
                TABLE_NAME,
                COLUMN_NAME,
                "Tipo1", "Tipo2", "Tipo3");

    }


    // Por cada tabla se crea una clase que implementa la interfaz BaseColumns
    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMN = new String[] {
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        };
        public static final String DEFAULT_SORT = COLUMN_NAME;

        /**
         * CREATE
         */
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        );

        /**
         * DELETE
         */
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        /**
         * INSERT
         */
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "Aula de 2CFGS",
                "2CFGS",
                "Aula de los resopladores de 2CFGS",
                "No tengo imagen"
        )+String.format(" ('%s','%s','%s','%s')",
                "Aula de 1CFGS",
                "1CFGS",
                "Aula de los resopladores de 1CFGS",
                "No tengo imagen"
        );

    }

    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_DEPENDENCYID = "idDependency";
        public static final String[] ALL_COLUMN = new String[] {
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCYID
        };

        /**
         * CREATE
         */
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s INTEGER NOT NULL)" ,
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCYID
        );

        /**
         * DELETE
         */
        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s",TABLE_NAME);

        /**
         * INSERT
         */
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),",
                TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_DEPENDENCYID,
                "Armario A",
                "ArmA",
                "Armario puerta madera",
                "1"
        )+String.format(" ('%s','%s','%s','%s')",
                "Armario B",
                "ArmB",
                "Armario puerta cristal",
                "1"
        );

    }

}
