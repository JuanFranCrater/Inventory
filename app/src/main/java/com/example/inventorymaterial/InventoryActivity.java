package com.example.inventorymaterial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/*
Esta actividad muestra datos de un inventario y permitira editar sus datos y su estado(aún no hay datos por tanto la activity solo muestra la interfaz
@author Juan Francisco
@version 17.10.20
 */
public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }
}
