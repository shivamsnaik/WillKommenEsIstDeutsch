package com.example.willkommenistdeutsch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Gidole-Regular.otf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        if(MainActivity.themeToggle)
        {
            this.setTheme(R.style.DarkTheme);
        }else
            this.setTheme(R.style.LightTheme);

        setContentView(R.layout.activity_about_us);
    }

    //ATTACHES NEW CONTEXT TO REFLECT CUSTOM FONT STYLE
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
