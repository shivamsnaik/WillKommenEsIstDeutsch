package com.example.willkommenistdeutsch.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.willkommenistdeutsch.R;

public class MainFragment extends Fragment {


    private Button greetingsBtn, weekNamesBtn, monthNameBtn;
    private Button whQuestionsBtn;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate((savedInstanceState));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
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

        //Click listeners
        greetingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.left_inward_slide, R.anim.right_outward_slide, R.anim.right_inward_slide, R.anim.left_outward_slide);
                ft.replace(R.id.linearMainLayout, new GreetingFragment());
                ft.commit();
            }
        });

        weekNamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.left_inward_slide, R.anim.right_outward_slide, R.anim.right_inward_slide, R.anim.left_outward_slide);
                ft.replace(R.id.linearMainLayout, new WeekNamesFragment());
                ft.commit();
            }
        });

        monthNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.left_inward_slide, R.anim.right_outward_slide, R.anim.right_inward_slide, R.anim.left_outward_slide);
                ft.replace(R.id.linearMainLayout, new MonthNameFragment());
                ft.commit();
            }
        });

        whQuestionsBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.left_inward_slide, R.anim.right_outward_slide, R.anim.right_inward_slide, R.anim.left_outward_slide);
                ft.replace(R.id.linearMainLayout, new WhQuestionFragment());
                ft.commit();
            }
        });
    }
}