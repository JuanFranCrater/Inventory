package com.example.inventorymaterial.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditInteractor {

    @Override
    public void validateDependency(String nombre, String shortname, String description, AddEditInteractor.OnAddDependecyListener listener) {
        if (TextUtils.isEmpty(nombre)) {
            listener.onNameEmptyError();
        } else if (TextUtils.isEmpty(shortname)) {
            listener.onShortNameEmptyError();
        } else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionError();
        } else if(true)//se pregunta si existe en la base de datos
        {
            DependencyRepository.getInstance().addDependency(new Dependency(DependencyRepository.getInstance().getDependencies().size()+1,nombre,shortname,description));
           listener.onSuccess();
        } else{
            listener.onDependencyDuplicated();
        }
    }
}
