package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContrat {
    interface View extends BaseView{
      void showDependency(List<Dependency> list);
      void showDeleteDependency();
      void showMessageList(String message);
        void showProgressBar();
        Dependency getDependency(Integer position);

        void hideProgressBar();
    }
    interface Presenter extends BasePresenter, Serializable {
        void loadDependency();

        void checkedActionMode();
        void setNewSelection(int position);

        void removeSelection(int position);

        void deleteSelection();

        void clearSelection();

        boolean isPositionChecked(int position);
    }
}
