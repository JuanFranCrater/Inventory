package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {
    void loadDependency();
    void deleteDependency(Dependency dependency);

    void getDependencyAtPosition(int i);

    interface OnLoadFinishedListener
    {
        void showDialog();
        void onSuccess(List<Dependency> list);
    }
}
