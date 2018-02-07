package com.example.inventorymaterial.data.provider.dao;

import android.content.ContentValues;

import com.example.inventorymaterial.data.db.dao.daoInterface.daoDependencyInterface;
import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyDao implements daoDependencyInterface {

    @Override
    public ArrayList<Dependency> loadAll() {

        return null;
    }

    @Override
    public boolean contains(Dependency dependency) {
        return false;
    }

    @Override
    public int update(Dependency d) {
        return 0;
    }

    @Override
    public long delete(Dependency d) {
        return 0;
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
    public void save(String name, String shortName, String description, String imageName) {

    }
}
