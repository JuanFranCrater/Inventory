package com.example.inventorymaterial.ui.product.Interactor;

import com.example.inventorymaterial.data.db.repository.ProductRepository;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductInteractorImpl implements AddProductInteractor {
    private final addListener listener;

    public AddProductInteractorImpl(addListener listener) {
        this.listener=listener;
    }

    @Override
    public void obtainData(int id) {
        listener.returnInner(ProductRepository.getInstance().getProducto(id));
    }
}
