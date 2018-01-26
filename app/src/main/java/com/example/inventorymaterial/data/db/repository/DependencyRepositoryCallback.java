package com.example.inventorymaterial.data.db.repository;

import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */

public interface DependencyRepositoryCallback {
    void onSucces();

    void load(ArrayList<Dependency> dependencies);
}
