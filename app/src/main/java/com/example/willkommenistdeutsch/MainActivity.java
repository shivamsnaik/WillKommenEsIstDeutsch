package com.example.willkommenistdeutsch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.willkommenistdeutsch.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    public static boolean themeToggle;
    static {
        themeToggle = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(themeToggle) {
            this.setTheme(R.style.DarkTheme);
            themeToggle = false;
        }
        else {
            this.setTheme(R.style.LightTheme);
            themeToggle = true;
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
            case R.id.toggle_dark_mode:
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