package com.example.willkommenistdeutsch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.willkommenistdeutsch.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    public static boolean themeToggle;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FETCHING SETTINGS DATA
        sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        themeToggle = sharedPreferences.getBoolean("dark_mode", true);


        if(themeToggle) {
            this.setTheme(R.style.DarkTheme);
        }
        else {
            this.setTheme(R.style.LightTheme);
        }

        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.linearMainLayout, new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            //TOGGLE DARK MODE
            case R.id.toggle_dark_mode:
                if(themeToggle)
                    themeToggle = false;
                else
                    themeToggle = true;

                /*STORE DARK MODE TOGGLE DATA TO LOCALSTORAGE*/
                sharedPreferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("dark_mode",themeToggle);
                editor.apply();

                restartApp();
                break;
            case R.id.about_us:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
        }
        return true;
    }

    public void restartApp()
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}