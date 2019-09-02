package com.example.willkommenistdeutsch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {


    private Button greetingsBtn, weekNamesBtn;
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
    public void onViewCreated(View view, Bundle bundle)
    {
        greetingsBtn = (Button) view.findViewById(R.id.greetingBtn);
        weekNamesBtn = (Button) view.findViewById(R.id.weekNames);


        //Click listeners
        greetingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.linearMainLayout, new GreetingFragment());
                fragmentTransaction.commit();
            }
        });

        weekNamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.linearMainLayout, new WeekNamesFragment());
                ft.commit();
            }
        });
    }
}
