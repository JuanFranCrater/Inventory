package com.example.inventorymaterial.data.db.dao.daoInterface;

import android.content.ContentValues;

import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public interface daoDependencyInterface {

    ArrayList<Dependency> loadAll();

    boolean contains(Dependency dependency);

    int update(Dependency d);

    long delete(Dependency d);

    ContentValues createContent(Dependency d);

    boolean exists(Dependency d);

    void save(String name, String shortName, String description, String imageName);
}
