package com.deutschlernen.deutschlernenzuzammen.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.activity.BeginnersActivity;
import com.deutschlernen.deutschlernenzuzammen.activity.GrammarA1Activity;
import com.deutschlernen.deutschlernenzuzammen.activity.GrammarA2Activity;


public class MainFragment extends Fragment {
    private Button  practiceBtn, beginnersBtn, grammarA1Btn, grammarA2Btn;

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
        practiceBtn = (Button) view.findViewById(R.id.practiceBtn);
        beginnersBtn = (Button) view.findViewById(R.id.beginnersBtn);
        grammarA1Btn = (Button) view.findViewById(R.id.grammerA1Btn);
        grammarA2Btn = (Button) view.findViewById(R.id.grammerA2Btn);

        //Click listeners
        practiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.setCustomAnimations(R.anim.right_inward_slide, R.anim.right_outward_slide, R.anim.right_inward_slide, R.anim.right_outward_slide);
                ft.add(R.id.linearMainLayout, new PracticeFragment());
                ft.commit();
            }
        });

        beginnersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BeginnersActivity.class));
            }
        });
        grammarA1Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GrammarA1Activity.class);
                startActivity(intent);
            }
        });

        grammarA2Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GrammarA2Activity.class);
                startActivity(intent);
            }
        });
    }
}
