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
import com.deutschlernen.deutschlernenzuzammen.fragments.levelone.ArticleFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.levelone.ConjugationFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.levelone.DativVerbenFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.levelone.RulesFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.levelone.TrennbarUntrennbarFragment;


public class GrammarA1Fragment extends Fragment implements View.OnClickListener {

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
        Button conjugationBtn = (Button) view.findViewById(R.id.conjugationBtn);
        Button dativVerbenBtn = (Button) view.findViewById(R.id.dativVerbenBtn);
        Button trenbarrUntrennbarVerbenBtn = (Button) view.findViewById(R.id.trenbarrUntrennbarVerbenBtn);
        Button rulesBtn = (Button) view.findViewById(R.id.rulesA1Btn);

        //Click listeners
        articleBtn.setOnClickListener(this);
        conjugationBtn.setOnClickListener(this);
        dativVerbenBtn.setOnClickListener(this);
        trenbarrUntrennbarVerbenBtn.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);

        switch (buttonId){
            case R.id.articleBtn:
                ft.add(R.id.linearGrammarA1Layout, new ArticleFragment());
                break;
            case R.id.conjugationBtn:
                ft.add(R.id.linearGrammarA1Layout, new ConjugationFragment());
                break;
            case R.id.dativVerbenBtn:
                ft.add(R.id.linearGrammarA1Layout, new DativVerbenFragment());
                break;
            case R.id.trenbarrUntrennbarVerbenBtn:
                ft.add(R.id.linearGrammarA1Layout, new TrennbarUntrennbarFragment());
                break;
            case R.id.rulesA1Btn:
                ft.add(R.id.linearGrammarA1Layout, new RulesFragment());
        }

        ft.commit();
    }
}
