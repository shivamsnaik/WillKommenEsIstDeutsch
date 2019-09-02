package com.example.willkommenistdeutsch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button greetingsBtn, weekNamesBtn;
    private static boolean themeToggle;

    static {
        themeToggle = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetingsBtn = (Button) findViewById(R.id.greetingBtn);
        weekNamesBtn = (Button) findViewById(R.id.weekNames);


        //Click listeners
        greetingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                startActivity(intent);
            }
        });

        weekNamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, WeekNamesActivity.class);
                startActivity(intent);
            }
        });
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
                if(themeToggle)
                {
                    themeToggle = false;
                    setTheme(R.style.LightTheme);
                    restartApp();
                }else
                {
                    themeToggle = true;
                    setTheme(R.style.DarkTheme);
                    restartApp();
                }

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