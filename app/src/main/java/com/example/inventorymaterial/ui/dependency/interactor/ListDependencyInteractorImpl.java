package com.example.inventorymaterial.ui.dependency.interactor;

import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.data.db.repository.DependencyRepositoryCallback;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyInteractor;

import java.util.ArrayList;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor, DependencyRepositoryCallback {
    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(ListDependencyInteractor.OnLoadFinishedListener listener) {
        this.listener=listener;
    }

    @Override
    public void loadDependency() {
        DependencyRepository.getInstance().getDependencies(this);
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependencyIterator(dependency);
        this.loadDependency();
    }

    @Override
    public void getDependencyAtPosition(int i) {
         DependencyRepository.getInstance().getDependencies(this);
    }

    @Override
    public void onSucces() {

    }

    @Override
    public void load(ArrayList<Dependency> dependencies) {
        listener.onSuccess(dependencies);
    }
}
