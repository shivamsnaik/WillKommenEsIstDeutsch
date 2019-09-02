package com.example.willkommenistdeutsch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(MainActivity.themeToggle)
        {
            this.setTheme(R.style.LightTheme);
        }else
            this.setTheme(R.style.DarkTheme);

        setContentView(R.layout.activity_about_us);
    }
}
