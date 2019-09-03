package com.example.willkommenistdeutsch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(MainActivity.themeToggle)
        {
            this.setTheme(R.style.DarkTheme);
        }else
            this.setTheme(R.style.LightTheme);

        setContentView(R.layout.activity_about_us);
    }
}
