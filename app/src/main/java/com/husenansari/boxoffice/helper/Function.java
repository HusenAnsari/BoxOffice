package com.husenansari.boxoffice.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.util.Objects;

/**
 * Created by gulamhusen on 10-04-2017.
 */

public class Function {
    public static String getJsonToStr(Objects objects){
        return MyApplication.getGson().toJson(objects);
    }
    public static void showToast(Context context,String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}

