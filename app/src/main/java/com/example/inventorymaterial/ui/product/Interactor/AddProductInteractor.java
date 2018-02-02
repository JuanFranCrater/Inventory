package com.example.inventorymaterial.ui.product.Interactor;

import com.example.inventorymaterial.data.db.model.ProductInner;

/**
 * Created by usuario on 2/02/18.
 */

public interface AddProductInteractor {
    void obtainData(int id);

    public interface addListener
    {

        void returnInner(ProductInner producto);
    }
}
