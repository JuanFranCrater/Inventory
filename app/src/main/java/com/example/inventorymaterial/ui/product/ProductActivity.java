package com.example.inventorymaterial.ui.product;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventorymaterial.R;

import java.util.List;

/*
Esta activity es un constrainLayout creado para editar o dar de alta un producto(solo muestra interface)
@author Juan Francisco
@version 17.10.20
 */
public class ProductActivity extends AppCompatActivity implements ListProduct.ListProductListener {

    public ListProduct listProduct;
    public AddProduct addProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_barrier);
        FragmentManager fraMag = getFragmentManager();
        FragmentTransaction fraTra = fraMag.beginTransaction();
        //1. Se crea la vista
        listProduct=(ListProduct) fraMag.findFragmentByTag(ListProduct.TAG);
        if(listProduct==null)
        {
            listProduct=(ListProduct) ListProduct.newInstance(null);
            fraTra.add(android.R.id.content,listProduct,ListProduct.TAG);
            fraTra.commit();

        }
    }

    @Override
    public void addNewProduct(Bundle bnd) {
        FragmentManager fraMag = getFragmentManager();
        FragmentTransaction fraTra = fraMag.beginTransaction();
        addProduct = (AddProduct) fraMag.findFragmentByTag(AddProduct.TAG);
        if(addProduct==null)
        {
            addProduct = (AddProduct) AddProduct.newInstance(bnd);
            fraTra.replace(android.R.id.content,addProduct,AddProduct.TAG);
            fraTra.addToBackStack(null);
            fraTra.commit();
        }
    }
}
