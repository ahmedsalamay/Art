package com.phantom.asalama.art.utill;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Utility {
        public static boolean isConnectedOrConnecting(Context context) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            assert cm != null;
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
        }

    public static String strSeparator = "__,__";
    public static String convertArrayToString(List<String> array){
        StringBuilder str = new StringBuilder();
        for (int i = 0;i<array.size(); i++) {
            str.append(array.get(i));
            // Do not append comma at the end of last element
            if(i<array.size()-1){
                str.append(strSeparator);
            }
        }
        return str.toString();
    }

    public static ArrayList<String> convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        ArrayList<String>retArray=new ArrayList<>();
        Collections.addAll(retArray, arr);
        return retArray;
    }

    public static boolean isLargeScreen(Context context){
        return (context.getResources().getConfiguration().screenLayout&
                Configuration.SCREENLAYOUT_SIZE_MASK)>=Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }
    public static boolean isLandScape(Context context){
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }
}
