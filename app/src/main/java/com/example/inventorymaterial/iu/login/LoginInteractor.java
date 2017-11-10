package com.example.inventorymaterial.iu.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginInteractor {
    void validateCredentials(String user, String password);

    interface OnLoginFinishedListener{
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordError();
        void onSuccess();
    }
}
