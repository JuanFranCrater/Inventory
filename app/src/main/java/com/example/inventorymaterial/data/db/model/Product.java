package com.example.inventorymaterial.data.db.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Product implements Parcelable {

    public static String TAG="Product";
    private int id;
    private String serial;
    private String modelcode;
    private String shortname;
    private String description;
    private int categorieID;
    private int subcategorieID;
    private int typeID;
    private int sectorID;
    private int status;
    private int quantity;
    private double value;
    private String vendor;
    private String bitmap;
    private String imageBase64;
    private String imageName;
    private String url;
    private String buyDate;
    private String notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModelcode() {
        return modelcode;
    }

    public void setModelcode(String modelcode) {
        this.modelcode = modelcode;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategorieID() {
        return categorieID;
    }

    public void setCategorieID(int categorieID) {
        this.categorieID = categorieID;
    }

    public int getSubcategorieID() {
        return subcategorieID;
    }

    public void setSubcategorieID(int subcategorieID) {
        this.subcategorieID = subcategorieID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Product(int id, String serial, String modelcode, String shortname, String description, int categorieID, int subcategorieID, int typeID, int sectorID, int status, int quantity, double value, String vendor, String bitmap, String imageBase64, String imageName, String url, String buyDate, String notes) {
        this.id = id;
        this.serial = serial;
        this.modelcode = modelcode;
        this.shortname = shortname;
        this.description = description;
        this.categorieID = categorieID;
        this.subcategorieID = subcategorieID;
        this.typeID = typeID;
        this.sectorID = sectorID;
        this.status = status;
        this.quantity = quantity;
        this.value = value;
        this.vendor = vendor;
        this.bitmap = bitmap;
        this.imageBase64 = imageBase64;
        this.imageName = imageName;
        this.url = url;
        this.buyDate = buyDate;
        this.notes = notes;
    }

    protected Product(Parcel in) {
        id = in.readInt();
        serial = in.readString();
        modelcode = in.readString();
        shortname = in.readString();
        description = in.readString();
        categorieID = in.readInt();
        subcategorieID = in.readInt();
        typeID = in.readInt();
        sectorID = in.readInt();
        status = in.readInt();
        quantity = in.readInt();
        value = in.readDouble();
        vendor = in.readString();
        bitmap = in.readString();
        imageBase64 = in.readString();
        imageName = in.readString();
        url = in.readString();
        buyDate = in.readString();
        notes = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(serial);
        parcel.writeString(modelcode);
        parcel.writeString(shortname);
        parcel.writeString(description);
        parcel.writeInt(categorieID);
        parcel.writeInt(subcategorieID);
        parcel.writeInt(typeID);
        parcel.writeInt(sectorID);
        parcel.writeInt(status);
        parcel.writeInt(quantity);
        parcel.writeDouble(value);
        parcel.writeString(vendor);
        parcel.writeString(bitmap);
        parcel.writeString(imageBase64);
        parcel.writeString(imageName);
        parcel.writeString(url);
        parcel.writeString(buyDate);
        parcel.writeString(notes);
    }
}
