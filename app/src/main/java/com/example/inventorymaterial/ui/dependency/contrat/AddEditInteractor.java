package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.ui.utils.AddEdit;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditInteractor {
    void validateDependency(String name, String shortname, String description, AddEdit mode);

    interface OnAddDependecyListener {
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onDescriptionError();

        void onDependencyDuplicated();

        void onSuccess();
    }
}
