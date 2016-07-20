package com.android.app.technicalassesment.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *
 * Checking the internet connection and return the boolean
 */

public class ConnectivityManger {

    public static boolean isConnecting(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected=false;
        if (null != connectivityManager) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

        }
        return isConnected;
    }


}