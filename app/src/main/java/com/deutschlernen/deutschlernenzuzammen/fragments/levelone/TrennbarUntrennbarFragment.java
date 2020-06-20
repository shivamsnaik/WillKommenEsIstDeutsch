package com.deutschlernen.deutschlernenzuzammen.fragments.levelone;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.service.TableService;


public class TrennbarUntrennbarFragment extends Fragment {
    String[] trenbarUntrenbarVerbsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trenbarUntrenbarVerbsList = getResources().getStringArray(R.array.trenbarUntrenbarVerbs);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.trennbar_untrennbar, container, false);
        new TableService().createRows(trenbarUntrenbarVerbsList, R.id.trenbarUntrenbarVerbsTable, view, this.getActivity());
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
