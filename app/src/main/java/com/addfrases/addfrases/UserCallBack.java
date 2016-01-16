package com.addfrases.addfrases;


import android.app.Activity;
import android.os.Bundle;

public abstract class UserCallBack extends Activity {

    //Variables
    public static String userName;
    public static String nameUser;
    public static String sobreUser;
    public static String fotoUser;
    public static String backgroundUser;


    @Override
    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        setContentView(R.layout.nav_header_main);

        // texto recuperado durante a transição de orientação de tela
        String username = inState.getString("username");
        userName = username;
    }


}


