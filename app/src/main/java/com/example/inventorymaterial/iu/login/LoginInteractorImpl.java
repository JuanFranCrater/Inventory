package com.example.inventorymaterial.iu.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
    //Si el password es vacío
        if(false) {
            listener.onPasswordEmptyError();
        }else if(false) {
            listener.onUserEmptyError();
        }else if(false) {
            listener.onPasswordError();
        } else {
            listener.onSuccess();
        }
        //Realiza las comprobaciones

        //Y es correcto

    }


}
