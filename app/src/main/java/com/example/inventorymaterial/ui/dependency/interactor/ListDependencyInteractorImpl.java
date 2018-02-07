package com.example.inventorymaterial.ui.dependency.interactor;

import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.data.db.repository.DependencyRepositoryCallback;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyInteractor;

import java.util.ArrayList;

public class ListDependencyInteractorImpl implements ListDependencyInteractor, DependencyRepositoryCallback {
    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(ListDependencyInteractor.OnLoadFinishedListener listener) {
        this.listener=listener;
    }

    @Override
    public void loadDependency() {

        new AsyncTask<Void, Void, ArrayList<Dependency>>() {

            @Override
            protected void onPostExecute(ArrayList<Dependency> dependencies) {

                listener.onSuccess(dependencies);
            }

            @Override
            protected ArrayList<Dependency> doInBackground(Void... voids) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return DependencyRepository.getInstance().getDependencies();
            }
        }.execute();
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependencyIterator(dependency);
        this.loadDependency();
    }

    @Override
    public void getDependencyAtPosition(int i) {

    }

    @Override
    public void onSucces() {

    }

    @Override
    public void load(ArrayList<Dependency> dependencies) {
        listener.onSuccess(dependencies);
    }
}
