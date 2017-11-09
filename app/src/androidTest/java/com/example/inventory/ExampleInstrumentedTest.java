package com.example.inventory;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//1. Login
//1.1 El usuario introduce un usuario/email(Instrumentales)

//1.2 El usuario introduce una contraseña(Instrumentales)

//2.Registro

//2.4 La contraseña tiene que tener al menos 6 caracteres (Instrumentales)

//2.7 Doble comprobacion de la contraseña (Instrumentales)

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //Caso de prueba que comprueba que el campo Usuario no esta vacío
    @Test
    public void isUserEmpty(){

    }

    //Caso de prueba que comprueba que el campo Email no esta vacío
    @Test
    public void isEmailEmpty() {

    }

    //Caso de prueba que comprueba que el campo Password no esta vacío
    @Test
    public void isPasswordEmpty() {

    }

    /**
     * Caso de prueba que comprueba la longitud de la contraseña
     */
    @Test
    public void passwordLength() {

    }

    @Test
    public void passwordDoubleCheck () {

    }

    }
