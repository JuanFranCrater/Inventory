package com.example.inventorymaterial.ui.dependency.interactor;

import android.text.TextUtils;
import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.data.db.repository.DependencyRepositoryCallback;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;
import com.example.inventorymaterial.ui.utils.AddEdit;

import java.util.ArrayList;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditInteractor, DependencyRepositoryCallback {

    private OnAddDependecyListener listener;

    public AddEditDependencyInteractorImpl(OnAddDependecyListener listener) {
        this.listener = listener;
    }

    @Override
    public void validateDependency(String name, String shortname, String description, AddEdit mode) {
        if (TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        } else if (TextUtils.isEmpty(shortname)) {
            listener.onShortNameEmptyError();
        } else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionError();
        } else {
            DependencyRepository.getInstance().addDependency(name,shortname,description,"",this);
        }
    }

    @Override
    public void onSucces() {
        listener.onSuccess();
    }

    @Override
    public void load(ArrayList<Dependency> dependencies) {
        listener.onSuccess();
    }
}
