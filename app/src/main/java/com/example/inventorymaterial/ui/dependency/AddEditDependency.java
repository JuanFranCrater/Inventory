package com.example.inventorymaterial.ui.dependency;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.ui.base.BaseFragment;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditContrat;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends BaseFragment implements AddEditContrat.View {
    AddNewDependencyClickListener callback;
    TextInputLayout tilname;
    TextInputLayout tilshortname;
    TextInputLayout tildescription;
    EditText edtName;
    public static final String TAG="addeditdependency";
    private AddEditContrat.Presenter presenter;


    @Override
    public void setPresenter(BasePresenter presenter) {
    this.presenter= (AddEditContrat.Presenter) presenter;
    }
    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments!=null)
        {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency,container,false);
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        tilname = rootView.findViewById(R.id.tilName);
        edtName= rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tilshortname = rootView.findViewById(R.id.tilShorname);
        tildescription = rootView.findViewById(R.id.tilDescription);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.validatedependency(tilname.getEditText().getText().toString(),tilshortname.getEditText().getText().toString(),tilshortname.getEditText().getText().toString());
            }
        });
        if(getArguments()!=null)//es editar
        {

        }
        return rootView;
    }


    @Override
    public void showListDependency() {
        addingCorrectDependency();
        showMessage("Dependency saved");

        //getActivity().finish();
        //startActivity(getActivity().getIntent());

    }

    @Override
    public void showErrorName() {
        tilname.setError(getResources().getString(R.string.errorNameEmpty));

    }

    @Override
    public void showErrorShortName() {
        tilshortname.setError(getResources().getString(R.string.errorShortNameEmpty));

    }

    @Override
    public void showErrorDescription() {
        tilshortname.setError(getResources().getString(R.string.errorDescriptionEmpty));

    }

    @Override
    public void showDependencyExitsError() {
        showMessage(getResources().getString(R.string.errorDependencyDuplicate));
    }

    @Override
    public void setNameEmptyError() {
    onError("NO name bitch");
    }

    @Override
    public void setShortNameEmptyError() {
        onError("NO shortname bitch");
    }

    @Override
    public void setDescriptionEmptyError() {
        onError("NO description bitch");
    }

    @Override
    public void addingCorrectDependency() {

        /* TODO Delegar a Presenter -> Interactor
        Dependency newDep = new Dependency(0, tID_DependencyName.getText().toString(),
                tID_DependencyShortname.getText().toString(),
                tID_DependencyDescription.getText().toString());
        DependencyRepository.getInstance().addDependency(newDep);
        */
        callback.returnToDependencyList();
    }

    /**
     *
     * Si no está implementada la interfaz, saltará excepción
     */

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (AddNewDependencyClickListener) activity;
        } catch (ClassCastException e)
        {
           // throw new ClassCastException(getActivity().getLocalClassName() + "must be implemented");
        }
    }

    interface AddNewDependencyClickListener
    {
        void returnToDependencyList();
    }
}
