package com.example.inventorymaterial.ui.product.Interactor;

import com.example.inventorymaterial.data.db.model.Product;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public interface ListProductInteractor {
    void loadDependency();
    void deleteDependency(Product product);

    void getDependencyAtPosition(int i);

    interface OnLoadFinishedListener
    {
        void onSuccess(List<Product> list);
    }
}
