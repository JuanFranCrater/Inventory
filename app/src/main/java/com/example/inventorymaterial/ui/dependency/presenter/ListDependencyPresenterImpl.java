package com.example.inventorymaterial.ui.dependency.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyInteractor;
import com.example.inventorymaterial.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenterImpl implements ListDependencyContrat.Presenter, ListDependencyInteractor.OnLoadFinishedListener{
    ListDependencyContrat.View view;
    ListDependencyInteractorImpl listDependencyInteractor;
    public ListDependencyPresenterImpl(ListDependencyContrat.View view) {
        this.view=view;
        this.listDependencyInteractor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependency() {
        view.showProgressBar();
        try {
            new AsyncTask() {
                @Override
                protected Object doInBackground(Object[] objects) {
                    listDependencyInteractor.loadDependency();
                    return null;
                }
            }.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void checkedActionMode() {

    }

    /**
     * Metodos que gestionan la seleccion multiple
     * @param position
     */
    HashMap<Integer, Boolean> selection= new HashMap<>();

    @Override
    public void setNewSelection(int position) {
        selection.put(position,true);
    }

    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }


    @Override
    public void deleteSelection() {

        for(Integer position:selection.keySet())
        {
            listDependencyInteractor.deleteDependency(getDependency(position));
        }

    }

    private Dependency getDependency(Integer position) {
        return view.getDependency(position);
    }

    @Override
    public void clearSelection() {
        selection.clear();
    }

    @Override
    public boolean isPositionChecked(int position) {
        return selection.get(position)==null?false:true;
    }

    @Override
    public void delete(Object dependency) {
        listDependencyInteractor.deleteDependency((Dependency) dependency);
        view.showDeleteDependency();
    }

    /**
     * Este método es llamado por el interactor cuando los datos/listado de dependencias esté listo. Se avisa a la vista
     * @param list
     */
    @Override
    public void onSuccess(List<Dependency> list) {
        view.showDependency(list);
        view.hideProgressBar();
    }


    @Override
    public void onDestroy() {
        view=null;
        listDependencyInteractor=null;
    }


}
