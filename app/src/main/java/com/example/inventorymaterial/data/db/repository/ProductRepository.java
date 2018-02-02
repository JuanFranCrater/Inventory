package com.example.inventorymaterial.data.db.repository;

import android.util.Log;

import com.example.inventorymaterial.data.db.dao.ProductDao;
import com.example.inventorymaterial.data.db.model.Product;
import com.example.inventorymaterial.data.db.model.ProductInner;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class ProductRepository {
    private ArrayList<Product> productos;
    private static ProductRepository repository;
    private ProductDao dao;

    static {
        repository = new ProductRepository();
    }
    private ProductRepository() {
        this.productos = new ArrayList<>();
        dao = new ProductDao();
    }
    public ArrayList<Product> getProductos() {
        productos = dao.loadAll();
        Log.d("Prueba", String.valueOf(productos.size()));
        return productos;
    }
    public static ProductRepository getInstance() {
        if (repository == null)
            repository = new ProductRepository();
        return repository;
    }

    public ProductInner getProducto(int id) {
        return dao.search(id);
    }
}
