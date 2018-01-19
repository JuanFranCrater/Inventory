package com.example.inventorymaterial.data.db;

import android.provider.BaseColumns;

import java.net.PortUnreachableException;

/**
 * Created by usuario on 19/01/18.
 */

public final class InventoryContrat {
    //La clase no  se puede instanciar
    private InventoryContrat() {

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";

    //Por cada tabla se crea un clase que implementa la interfaz BaseColumns

    public static class DependencyEntry implements BaseColumns {
        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMN = new String[]
                {
                        BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME
                };
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL)",
                TABLE_NAME, BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS " + "%s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s'),", TABLE_NAME,
                COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGENAME
                , "AULA DE 2CFGS", "2CFGS", "AULA DE LOS RESOPLADORES DE 2CFGS", "AVERSIMEMUERO") +
                String.format("('%s','%s','%s','%s'),", "AULA DE 2CFGS", "2CFGS", "AULA DE LOS RESOPLADORES DE 2CFGS", "AVERSIMEMUERO") +
                String.format("('%s','%s','%s','%s')", "AULA DE 2CFGS", "2CFGS", "AULA DE LOS RESOPLADORES DE 2CFGS", "AVERSIMEMUERO");
    }

    public static class SectorEntry implements BaseColumns {
        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_DEPEDENCYID = "dependencyid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGEBASE64 = "imageName64";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String[] ALL_COLUMN = new String[]
                {
                        BaseColumns._ID, COLUMN_DEPEDENCYID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGEBASE64, COLUMN_IMAGENAME
                };
        public static final String SQL_CREATE_ENTRIES = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s INTEGER NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL," + "%s TEXT NOT NULL)"+
                        "FOREIGN KEY("+COLUMN_DEPEDENCYID+") REFERENCES "+DependencyEntry.TABLE_NAME+"("+BaseColumns._ID+")",
                TABLE_NAME, BaseColumns._ID, COLUMN_DEPEDENCYID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGEBASE64, COLUMN_IMAGENAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS " + "%s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) VALUES ('%i','%s','%s','%s','%s','%s'),", TABLE_NAME,
                COLUMN_DEPEDENCYID, COLUMN_NAME, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_IMAGEBASE64, COLUMN_IMAGENAME
                , 1, "AULA DE 2CFGS", "2CFGS", "AULA DE LOS RESOPLADORES DE 2CFGS", "AVERSIMEMUERO", "AVERSIMEMUEROFUERTEESTANOCHE");

    }
}
