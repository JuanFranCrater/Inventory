package com.example.inventorymaterial.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.inventorymaterial.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Método que comprueba que la contraseña tenga los siguientes requisitos
     * Debe contener al menos un dígito 0-9
     * Debe contener al menos un caracter en mayúscula
     * Debe contener al menos un caracter en minuscula
     * Debe contener una longitud de al menos seis carácteres
     * @param password
     * @return
     */
    /**
     *       (?=.*\d)             contiene un digito(escapamos la barra)
             (?=.*[a-z])		  contiene una minuscula
             (?=.*[A-Z])		  contiene una mayuscula
                .                 cumple todas las condiciones anteriores
                {6,}	          al menos 6 caracteres
     )
     */


    public static ProgressDialog showProgressDialog(Context context) {
        final ProgressDialog progreso = new ProgressDialog(context);
        progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progreso.setMessage("Obteniendo datos");
        progreso.setCancelable(false);
        return progreso;

    }
    public static boolean isPasswordValid(String password)
    {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})";
        pattern=Pattern.compile(PASSWORD_PATTERN);
        matcher=pattern.matcher(password);
        return matcher.matches();
    }
}
