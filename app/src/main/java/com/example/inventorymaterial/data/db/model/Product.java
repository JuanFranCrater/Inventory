package com.example.inventorymaterial.data.db.model;


import java.util.Date;

public class Product {

    private int id;
    private String name;
    private String serial;
    private String seller;
    private String model;
    private Categoria categorie;
    private Tipo type;
    private String description;
    private float price;
    private Date buyDate;
    private String url;
    private String notes;

    public Product(int id, String name, String serial, String seller, String model, Categoria categorie, Tipo type, String description, float price, Date buyDate, String url, String notes) {
        this.id = id;
        this.name = name;
        this.serial = serial;
        this.seller = seller;
        this.model = model;
        this.categorie = categorie;
        this.type = type;
        this.description = description;
        this.price = price;
        this.buyDate = buyDate;
        this.url = url;
        this.notes = notes;
    }

    public int getid() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Categoria getCategorie() {
        return categorie;
    }

    public void setCategorie(Categoria categorie) {
        this.categorie = categorie;
    }

    public Tipo getType() {
        return type;
    }

    public void setType(Tipo type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
