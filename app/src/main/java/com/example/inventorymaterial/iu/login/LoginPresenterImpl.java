package com.example.inventorymaterial.iu.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginInteractorImpl loginInteractorImpl;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractorImpl = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String password) {
        loginInteractorImpl.validateCredentials(user,password);
    }
}
