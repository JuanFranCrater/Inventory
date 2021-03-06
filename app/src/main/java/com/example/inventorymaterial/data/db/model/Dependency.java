package com.example.inventorymaterial.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by usuario on 25/10/17.
 */

public class Dependency implements Comparable,Parcelable {

    /*CAMPOS*/
    private int _ID;
    private String name;
    private String sortName;
    private String description;
    private String imageName;
    public static String TAG = "Dependency";

    /*CONSTRUCTOR*/
    public Dependency(int _ID, String name, String shortame, String description, String imageName) {
        this._ID = _ID;
        this.name = name;
        this.sortName = shortame;
        this.description = description;
        this.imageName = imageName;
    }

    /*METODOS*/
    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String shortame) {
        this.sortName = shortame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "_ID=" + _ID +
                ", name='" + name + '\'' +
                ", shortame='" + sortName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * Ordenar por nombre
     * @param o
     * @return
     * menor a 0 es mas pequeño, anterior
     * 0  igual
     * mayoy 0 es mas grande, posterior
     */
    @Override
    public int compareTo(@NonNull Object o) {
        return name.compareTo(((Dependency)o).getName());
    }


    public static class DependencyOrderByShortName implements Comparator<Dependency> {

        @Override
        public int compare(Dependency d1, Dependency d2) {
            return d1.getSortName().toUpperCase().compareTo(d2.getSortName().toUpperCase());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(sortName);
        dest.writeString(description);
        dest.writeString(imageName);
    }

    protected Dependency(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        sortName = in.readString();
        description = in.readString();
        imageName = in.readString();
    }

    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };

}