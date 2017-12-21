package com.example.inventorymaterial.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.inventorymaterial.ui.inventory.InventoryApplication;
import com.example.inventorymaterial.ui.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper,GeneralPreferencesHelper {
    private static final String TAG = "AppPreferencesHelper";
    /**
     * 1) Se define todas las Key posibles del fichero preferences
     */
    public interface AppPreferencesListerner
    {
        void onSharedPrerenceChange();
    }
    //2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;



    private AppPreferencesHelper() {
        //Si es el fichero por defecto de las preferencias
        this.preferences = PreferenceManager.getDefaultSharedPreferences(InventoryApplication.getContext());
        listener= new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

                InventoryApplication.getContext();

                Log.d(TAG, "onSharedPreferenceChanged: Se ha cambiado la key");
            }
        };
        //Si es un fichero con nombre diferente
    }

    public static AppPreferencesHelper getInstance()
    {
        if(instance==null)
        {
            instance=new AppPreferencesHelper();
        }
        return instance;
    }

    /**
     * ID SQLite
     * @return
     */
    public long getCurrentUserId() {
        long id=preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName() {
        String name=preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public String getCurrentUserPassword() {
        String password=preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }

    public boolean getCurrentUserRemember() {
        boolean Remember=preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return Remember;
    }


    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID,id).apply();
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME,name).apply();
    }

    public void setCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD,password).apply();
    }

    public void setCurrentUserRemember(boolean remember) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER,remember).apply();
    }

}
