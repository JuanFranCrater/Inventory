package com.example.inventorymaterial.ui.product.Presenter;

import com.example.inventorymaterial.data.db.model.ProductInner;
import com.example.inventorymaterial.ui.product.Interactor.AddProductInteractor;
import com.example.inventorymaterial.ui.product.Interactor.AddProductInteractorImpl;
import com.example.inventorymaterial.ui.product.contrat.AddProductContrat;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductPresenterImpl implements AddProductContrat.Presenter, AddProductInteractor.addListener {

    private AddProductInteractor interactor;
    private AddProductContrat.View view;

    public AddProductPresenterImpl(AddProductContrat.View view) {
        interactor=new AddProductInteractorImpl(this);
        this.view=view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadSpinners(int id) {
        interactor.obtainData(id);
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void returnInner(ProductInner producto) {
        view.loadSpinners(producto);
    }
}
