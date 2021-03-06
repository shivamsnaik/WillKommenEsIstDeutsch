package com.deutschlernen.deutschlernenzuzammen.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.fragments.TranslatorFragment;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class TranslatorActivity extends AppCompatActivity {

    private static final String TAG = "sdsds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Custom font
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Gidole-Regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        updateUI();
    }

    private void updateUI() {
        setContentView(R.layout.activity_translator);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.translatorLinearLayout, new TranslatorFragment());
        ft.commit();
    }

    //ATTACHES NEW CONTEXT TO REFLECT CUSTOM FONT STYLE
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
