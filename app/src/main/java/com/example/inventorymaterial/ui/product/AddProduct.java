package com.example.inventorymaterial.ui.product;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.data.db.model.ProductInner;
import com.example.inventorymaterial.ui.base.BaseFragment;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.product.Presenter.AddProductPresenterImpl;
import com.example.inventorymaterial.ui.product.contrat.AddProductContrat;

/**
 * Created by usuario on 1/02/18.
 */

public class AddProduct  extends BaseFragment implements AddProductContrat.View{
    public static final String TAG = "addProduct";
    private ListProduct.ListProductListener callback;
    private AddProductContrat.Presenter presenter;
    private Product product;
    private ProductInner productInner;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListProduct.ListProductListener) activity;
        } catch (ClassCastException e) {
            // throw new ClassCastException(activity.toString()+" must implements ListDependencyListener");
        }
    }
    public static Fragment newInstance(Bundle arguments) {
        AddProduct addProduct = new AddProduct();
        if(arguments!=null)
        {
            addProduct.setArguments(arguments);
        }
        return addProduct;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    EditText edtNombre,edtSerial,edtVendedor,edtModelo,edtDescripcion,edtPrecio,edtFechaCompra,edtUrl,edtNotas,edtCategory,edttipo,edtSubcategory;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        this.presenter= new AddProductPresenterImpl(this);
        View rootView = inflater.inflate(R.layout.fragment_add_edit_product,container,false);
        edtNombre=rootView.findViewById(R.id.edtNombre);
        edtSerial = rootView.findViewById(R.id.edtSerial);
        edtVendedor =rootView.findViewById(R.id.edtVendedor);
        edtModelo = rootView.findViewById(R.id.edtModelo);
        edtDescripcion = rootView.findViewById(R.id.edtDescripcion);
        edtPrecio = rootView.findViewById(R.id.edtPrecio);
        edtFechaCompra = rootView.findViewById(R.id.edtFechaCompra);
        edtUrl = rootView.findViewById(R.id.edtUrl);
        edtNotas = rootView.findViewById(R.id.edtNotas);
        edtCategory=rootView.findViewById(R.id.spnCategoria);
        edtSubcategory=rootView.findViewById(R.id.spnSubcategoria);
        edttipo=rootView.findViewById(R.id.spnTipo);
        if(getArguments()!=null)//es editar
        {
            product=getArguments().getParcelable("Product");
            edtNombre.setText(product.getShortname());
            edtSerial.setText(product.getSerial());
            edtVendedor.setText(product.getVendor());
            edtModelo.setText(product.getModelcode());
            edtDescripcion.setText(product.getDescription());
            edtPrecio.setText( String.valueOf(product.getValue()));
            edtFechaCompra.setText(product.getBuyDate());
            edtUrl.setText(product.getUrl());
            edtNotas.setText(product.getNotes());
            presenter.loadSpinners(product.getId());
        }
        Log.d("Datos",product.getShortname());
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("presenter",presenter);
    }
    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter= (AddProductContrat.Presenter) presenter;
    }

    @Override
    public void loadSpinners(ProductInner producto) {
        edttipo.setText(producto.getTypeName());
        edtCategory.setText(producto.getCategorieName());
        edtSubcategory.setText(producto.getSubcategorieID());
    }
}
