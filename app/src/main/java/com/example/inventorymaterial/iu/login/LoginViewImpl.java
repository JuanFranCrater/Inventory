package com.example.inventorymaterial.iu.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inventorymaterial.DashboardActivity;
import com.example.inventorymaterial.R;

/*
Esta activity es el login de la aplicacion donde el usuario se conectara(no hace login aún, se entra sea cuales sean los datos introducidos)
@author Juan Francisco
@version 17.10.20
 */

public class LoginViewImpl extends AppCompatActivity {

    Button btnSingIn;
    LoginPresenter loginPresenter;
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
                    loginPresenter.validateCredentials("Lourdes","Lourdes");
                }
        }
    });



    }
   // Intent intnt = new Intent(LoginViewImpl.this,DashboardActivity.class);
   // startActivity(intnt);
}
