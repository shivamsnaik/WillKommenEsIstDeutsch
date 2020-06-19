package com.deutschlernen.deutschlernenzuzammen.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.widget.Toast;

public class PopupService {

    public static void showPopupForFeatureUpdate(Context context, SharedPreferences sharedPreferencesObj, String featureName, String popupText){
        boolean val = sharedPreferencesObj.getBoolean(featureName,false);
        if(false == val){

            SharedPreferences.Editor editor = sharedPreferencesObj.edit();
            editor.putBoolean(featureName,true);
            editor.apply();

            Toast toast = Toast.makeText(context, popupText, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);

            toast.show();
        }
    }
}
