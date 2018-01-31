package com.example.inventorymaterial.data.db.model;

/**
 * Created by PcCom on 31/01/2018.
 */

public class Categoria {
    private int id;
    private String name;

    public Categoria(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getid() {
        return id;
    }

    public void setid(int _id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
