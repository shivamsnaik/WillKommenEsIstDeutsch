package com.deutschlernen.deutschlernenzuzammen.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.fragments.leveltwo.AdjektivEndingsFragment;


public class GrammarA2Fragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate((savedInstanceState));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_grammar_a2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle bundle)
    {
        Button adjektivEndingBtn = (Button) view.findViewById(R.id.adjektivEndingBtn);

        //Click listeners
        adjektivEndingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);

        switch (buttonId) {
            case R.id.adjektivEndingBtn:
                ft.add(R.id.linearGrammarA2Layout, new AdjektivEndingsFragment());
                break;
        }
        ft.commit();
    }
}
