package com.example.inventorymaterial.ui.product.contrat;

import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.base.BaseView;

import java.io.Serializable;

/**
 * Created by usuario on 1/02/18.
 */

public interface AddProductContrat {
    interface View extends BaseView
    {}
    interface Presenter extends Serializable,BasePresenter {
        void onDestroy();
    }
}
