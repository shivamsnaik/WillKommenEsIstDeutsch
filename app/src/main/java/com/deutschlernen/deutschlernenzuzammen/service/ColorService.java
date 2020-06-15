package com.deutschlernen.deutschlernenzuzammen.service;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;

import com.android.deutschlernenzuzammen.R;

public class ColorService {

    public static int getColor(Context context, int colorAttributeName) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttributeName, typedValue, true);
        int color = ContextCompat.getColor(context, typedValue.resourceId);

        return color;
    }
}
