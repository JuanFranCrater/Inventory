package com.example.inventorymaterial.ui.product;

import android.app.Fragment;
import android.os.Bundle;

import com.example.inventorymaterial.ui.base.BaseFragment;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.product.contrat.AddProductContrat;

/**
 * Created by usuario on 1/02/18.
 */

public class AddProduct  extends BaseFragment implements AddProductContrat.View{
    public static final String TAG = "addProduct";
    private AddProductContrat.Presenter presenter;

    public static Fragment newInstance(Bundle arguments) {
        AddProduct addProduct = new AddProduct();
        if(arguments!=null)
        {
            addProduct.setArguments(arguments);
        }
        return addProduct;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter= (AddProductContrat.Presenter) presenter;
    }
}
