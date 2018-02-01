package com.example.inventorymaterial.ui.product.contrat;

import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public interface ListProductContrat {

    interface View extends BaseView
    {
        void showProducts(List<Product> list);
    }
    interface Presenter extends BasePresenter, Serializable
    {

        void loadProducts();
    }
}
