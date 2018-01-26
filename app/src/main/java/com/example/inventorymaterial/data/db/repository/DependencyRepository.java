package com.example.inventorymaterial.data.db.repository;


import com.example.inventorymaterial.data.db.dao.DependencyDao;
import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by
 * @creator Juan Francisco
 */

public class DependencyRepository {


    private ArrayList<Dependency> dependencies;
    private DependencyDao dao;
    private static DependencyRepository dependencyRepository;

    static {
        dependencyRepository = new DependencyRepository();
    }

    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        this.dao = new DependencyDao();
    }


    public static DependencyRepository getInstance() {

        if (dependencyRepository == null) {
            dependencyRepository = new DependencyRepository();
        }
        return dependencyRepository;
    }

    public void editDependencyById(int id, String name, String shortname, String description) {
        for (int i = 0; i < dependencies.size(); i++) {
            if (dependencies.get(i).get_ID() == id) {
                dependencies.get(i).setName(name);
                dependencies.get(i).setSortName(shortname);
                dependencies.get(i).setDescription(description);
            }
        }
    }

    public int getDependencyBy(String name, String shortname) {
        for (int i = 0; i < dependencies.size(); i++) {
            //Log.e(String.valueOf(dependencies.get(i).get_ID()),String.valueOf(name+"--"+shortname));
            if (dependencies.get(i).getName().equals(name) && dependencies.get(i).getSortName().equals(shortname)) {
                return dependencies.get(i).get_ID();
            }
        }
        return -1;
    }

    public void getDependencies(DependencyRepositoryCallback callback) {

        callback.load(dao.loadAll());

    }

    public void saveDependency(Dependency d, DependencyRepositoryCallback callback) {
        long result = dao.update(d);
        callback.onSucces();
    }

    public ArrayList<Dependency> getDependenciesByShortName() {
        Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }

    public void deleteDependencyIterator(Dependency d) {
        dao.delete(d);
    }

    public void addDependency(String name, String shortName, String description, String imageName, DependencyRepositoryCallback callback) {
        dao.save(name, shortName, description, imageName);
        callback.onSucces();
    }
}
