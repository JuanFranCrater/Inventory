package com.example.inventorymaterial.ui.product.Interactor;

import android.util.Log;

import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.data.db.repository.ProductRepository;
import com.example.inventorymaterial.ui.product.Presenter.ListProductPresenterImpl;
import com.example.inventorymaterial.ui.product.contrat.ListProductContrat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductInteractorImpl implements ListProductInteractor {
    private final ListProductInteractor.OnLoadFinishedListener listener;

    public ListProductInteractorImpl(ListProductInteractor.OnLoadFinishedListener listener) {
        this.listener=listener;
    }

    @Override
    public void loadDependency() {
        ArrayList<Product> list= ProductRepository.getInstance().getProductos();
        Log.d("Prueba", String.valueOf(list.size()));
        listener.onSuccess(list);
    }

    @Override
    public void deleteDependency(Product product) {

    }

    @Override
    public void getDependencyAtPosition(int i) {

    }
}
