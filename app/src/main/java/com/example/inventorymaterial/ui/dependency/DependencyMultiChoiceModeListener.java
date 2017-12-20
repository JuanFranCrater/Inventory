package com.example.inventorymaterial.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;
import com.example.inventorymaterial.ui.dependency.presenter.ListDependencyPresenterImpl;

/**
 * Created by usuario on 18/12/17.
 */

class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

    private ListDependencyContrat.Presenter presenter;
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContrat.Presenter presenter) {
        this.presenter = presenter;
        count=0;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int position, long l, boolean checked) {
        if(checked)
        {
            count++;
            presenter.setNewSelection(position);
        }
        else
        {
            count--;
            presenter.removeSelection(position);
        }
        actionMode.setTitle(count+" seleccionados");
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater inflater = actionMode.getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_listdependency,menu);
        actionMode.setTitle("Iniciando ActionMode");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.action_listdependency_delete:
                presenter.deleteSelection();
                break;
        }

        actionMode.finish();
        presenter.loadDependency();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        count=0;
        presenter.clearSelection();
    }
}
