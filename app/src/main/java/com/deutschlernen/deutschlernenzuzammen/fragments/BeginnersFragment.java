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
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.AlphabetFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.GreetingFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.MonthNameFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.NumbersFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.WeekNamesFragment;
import com.deutschlernen.deutschlernenzuzammen.fragments.beginner.WhQuestionFragment;


public class BeginnersFragment extends Fragment implements View.OnClickListener {

    private Button numbersBtn, greetingsBtn, weekNamesBtn, monthNameBtn;
    private Button whQuestionsBtn, alphabetsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate((savedInstanceState));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_beginners, container, false);
        return view;
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
        greetingsBtn = (Button) view.findViewById(R.id.greetingBtn);
        weekNamesBtn = (Button) view.findViewById(R.id.weekNamesBtn);
        monthNameBtn = (Button) view.findViewById(R.id.monthNamesBtn);
        whQuestionsBtn = (Button) view.findViewById(R.id.whQuestionsBtn);
        numbersBtn = (Button) view.findViewById(R.id.numbersBtn);
        alphabetsBtn = (Button) view.findViewById(R.id.alphabetsBtn);

        //On click listeners
        numbersBtn.setOnClickListener(this);
        alphabetsBtn.setOnClickListener(this);
        greetingsBtn.setOnClickListener(this);
        weekNamesBtn.setOnClickListener(this);
        monthNameBtn.setOnClickListener(this);
        whQuestionsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();

        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.left_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);

        switch (buttonId){
            case R.id.numbersBtn:
                ft.add(R.id.linearBeginnersLayout, new NumbersFragment());
                break;
            case R.id.alphabetsBtn:
                ft.add(R.id.linearBeginnersLayout, new AlphabetFragment());
                break;
            case R.id.greetingBtn:
                ft.add(R.id.linearBeginnersLayout, new GreetingFragment());
                break;
            case R.id.weekNamesBtn:
                ft.add(R.id.linearBeginnersLayout, new WeekNamesFragment());
                break;
            case R.id.monthNamesBtn:
                ft.add(R.id.linearBeginnersLayout, new MonthNameFragment());
                break;
            case R.id.whQuestionsBtn:
                ft.add(R.id.linearBeginnersLayout, new WhQuestionFragment());
        }

        ft.commit();
    }
}
