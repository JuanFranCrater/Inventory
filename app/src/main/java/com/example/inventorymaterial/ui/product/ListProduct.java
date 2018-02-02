package com.example.inventorymaterial.ui.product;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.adapter.ProductAdapter;
import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.product.Presenter.ListProductPresenterImpl;
import com.example.inventorymaterial.ui.product.contrat.ListProductContrat;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProduct extends ListFragment implements ListProductContrat.View {
    public static final String TAG = "listProduct";
    private ListProductListener callback;
    private ListProductContrat.Presenter presenter;
    private ProductAdapter adapter;
    private ListView listView;

    @Override
    public void showProducts(List<Product> list) {
        adapter.clear();
        Log.d("Prueba", String.valueOf(list.size()));
        adapter.addAll(list);
    }

    interface ListProductListener {
        void addNewProduct(Bundle bnd);
    }
    public static Fragment newInstance(Bundle arguments) {
        ListProduct listProduct = new ListProduct();
        if(arguments!=null)
        {
            listProduct.setArguments(arguments);
        }
        return listProduct;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new ProductAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListProductListener) activity;
        } catch (ClassCastException e) {
            // throw new ClassCastException(activity.toString()+" must implements ListDependencyListener");
        }
    }
    public ListProduct() {}

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        adapter=null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        this.presenter= new ListProductPresenterImpl(this);
        //Como el fragment mantiene el estado/y sólo elimina la vista)
        //se debe reinicializar el presenter cuando se crea la vista
        View rootView = inflater.inflate(R.layout.fragment_list_product,container,false);
        setHasOptionsMenu(true);
        //Como se encuentra en el fragment, usamos rootView
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        ListView listView = (ListView)rootView.findViewById(android.R.id.list);
        //Si el floatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
             //   callback.addNewProduct(null);
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bnd = new Bundle();
                bnd.putParcelable(Product.TAG, (Product)adapterView.getItemAtPosition(i));
              callback.addNewProduct(bnd);
            }
        });
        presenter.loadProducts();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("presenter",presenter);
    }
    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter= (ListProductContrat.Presenter) presenter;
    }
}
