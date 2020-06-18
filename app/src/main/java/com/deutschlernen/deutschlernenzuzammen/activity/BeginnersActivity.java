package com.deutschlernen.deutschlernenzuzammen.activity;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.fragments.BeginnersFragment;

public class BeginnersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beginners);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.linearBeginnersLayout, new BeginnersFragment());
        fragmentTransaction.commit();
    }
}
