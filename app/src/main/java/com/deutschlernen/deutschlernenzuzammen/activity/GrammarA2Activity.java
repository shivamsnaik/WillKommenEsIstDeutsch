package com.deutschlernen.deutschlernenzuzammen.activity;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.fragments.GrammarA2Fragment;

public class GrammarA2Activity extends BaseActivity {

    Button articleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grammar_a2);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.linearGrammarA2Layout, new GrammarA2Fragment());
        fragmentTransaction.commit();
    }
}
