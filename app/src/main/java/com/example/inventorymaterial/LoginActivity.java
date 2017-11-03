package com.example.inventorymaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
Esta activity es el login de la aplicacion donde el usuario se conectara(no hace login aún, se entra sea cuales sean los datos introducidos)
@author Juan Francisco
@version 17.10.20
 */

public class LoginActivity extends AppCompatActivity {

    Button btnSingIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSingIn=(Button)findViewById(R.id.btnSignIN);
        btnSingIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(v==btnSingIn){
                    Intent intnt = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intnt);
                }
        }
    });



    }
}
