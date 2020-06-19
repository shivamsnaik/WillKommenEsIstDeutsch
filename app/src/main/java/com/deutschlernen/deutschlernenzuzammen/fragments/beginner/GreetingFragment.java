package com.deutschlernen.deutschlernenzuzammen.fragments.beginner;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.service.TableRows;


public class GreetingFragment extends Fragment {

    String[] greetingsList;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        greetingsList = getResources().getStringArray(R.array.greetings);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_greeting, container, false);
        TableRows.createRows(greetingsList,R.id.greetingsTable, view, this.getActivity());
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
}
