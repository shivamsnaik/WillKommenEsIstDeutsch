package com.deutschlernen.deutschlernenzuzammen.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.fragments.MainFragment;
import com.deutschlernen.deutschlernenzuzammen.service.PopupService;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ADD FEATURE TO SHOW POP UP IF FEATURE UPDATED ON PHONE FOR FIRST TIME
        PopupService.showPopupForFeatureUpdate(this.getBaseContext(), sharedPreferences, "noun_personal_pronoun_shoutout",
                "UPDATE - Two new Pages added:" +
                        "\n1. Nouns " +
                        "\n2. Personal Pronouns" +
                        "\n3. Added few examples in CONJUGATION page");

        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.linearMainLayout, new MainFragment());
        fragmentTransaction.commit();
    }


}