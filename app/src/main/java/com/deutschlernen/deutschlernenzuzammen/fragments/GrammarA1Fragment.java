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


public class GrammarA1Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate((savedInstanceState));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_grammar_a1, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onViewCreated(View view, Bundle bundle)
    {
        Button articleBtn = (Button) view.findViewById(R.id.articleBtn);
        Button dativVerbenBtn = (Button) view.findViewById(R.id.dativVerbenBtn);
        Button trenbarrUntrennbarVerbenBtn = (Button) view.findViewById(R.id.trenbarrUntrennbarVerbenBtn);
        Button rulesBtn = (Button) view.findViewById(R.id.rulesA1Btn);

        //Click listeners
        trenbarrUntrennbarVerbenBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.left_inward_slide, R.anim.right_outward_slide);
                ft.add(R.id.linearGrammarA1Layout, new TrennbarUntrennbarFragment());
                ft.commit();
            }
        });

        dativVerbenBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);
                ft.add(R.id.linearGrammarA1Layout, new DativVerbenFragment());
                ft.commit();
            }
        });

        articleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);
                ft.add(R.id.linearGrammarA1Layout, new ArticleFragment());
                ft.commit();
            }
        });

        rulesBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);
                ft.add(R.id.linearGrammarA1Layout, new RulesFragment());
                ft.commit();
            }
        });
    }
}
