package com.example.inventorymaterial.ui.product.Presenter;

import android.util.Log;

import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.ui.product.Interactor.ListProductInteractor;
import com.example.inventorymaterial.ui.product.Interactor.ListProductInteractorImpl;
import com.example.inventorymaterial.ui.product.contrat.ListProductContrat;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductPresenterImpl implements ListProductContrat.Presenter, ListProductInteractor.OnLoadFinishedListener {

    private ListProductContrat.View view;
    ListProductInteractorImpl interactor;

    public ListProductPresenterImpl(ListProductContrat.View view) {
        this.view=view;
        interactor=new ListProductInteractorImpl(this);
    }

    @Override
    public void onDestroy() {
        view=null;
        interactor=null;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void loadProducts() {
        interactor.loadDependency();
    }

    //......//

    @Override
    public void onSuccess(List<Product> list) {
        Log.d("Prueba", String.valueOf(list.size()));
        view.showProducts(list);
    }
}
