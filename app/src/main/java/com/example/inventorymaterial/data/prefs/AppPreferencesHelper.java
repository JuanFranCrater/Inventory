package com.example.inventorymaterial.data.prefs;

import android.content.SharedPreferences;

import com.example.inventorymaterial.ui.dependency.contrat.AddEditContrat;
import com.example.inventorymaterial.ui.inventory.InventoryApplication;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements PreferencesHelper {
    /**
     * 1) Se define todas las Key posibles del fichero preferences
     */
    private static final String PREF_KEY_CURRENT_USER_ID="pref_key_current_user_id";
    private static final String PREF_KEY_CURRENT_USER_NAME="pref_key_current_user_name";
    private static final String PREF_KEY_CURRENT_USER_PASSWORD="pref_key_current_user_password";
    private static final String PREF_KEY_CURRENT_USER_REMEMBER="pref_key_current_user_remeber";

    //2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private AppPreferencesHelper instance;

    private AppPreferencesHelper() {
        //Si es el fichero por defecto de las preferencias
        this.preferences = (InventoryApplication.getContext()).getDefaultSharedPreferences();
        //Si es un fichero con nombre diferente
    }

    public AppPreferencesHelper getInstance()
    {
        if(instance==null)
        {
            instance=new AppPreferencesHelper();
        }
        return instance;
    }
}
