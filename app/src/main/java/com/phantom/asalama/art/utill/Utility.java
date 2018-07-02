package com.phantom.asalama.art.utill;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;

public final class Utility {
        public static boolean isConnectedOrConnecting(Context context) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            return isConnected;
        }

    public static String strSeparator = "__,__";
    public static String convertArrayToString(List<String> array){
        String str = "";
        for (int i = 0;i<array.size(); i++) {
            str = str+array.get(i);
            // Do not append comma at the end of last element
            if(i<array.size()-1){
                str = str+strSeparator;
            }
        }
        return str;
    }
    public static ArrayList<String> convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        ArrayList<String>retArray=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            retArray.add(arr[i]);
        }
        return retArray;
    }
}
