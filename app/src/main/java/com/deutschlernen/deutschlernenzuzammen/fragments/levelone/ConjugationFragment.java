package com.deutschlernen.deutschlernenzuzammen.fragments.levelone;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.model.Table;
import com.deutschlernen.deutschlernenzuzammen.service.TableService;

public class ConjugationFragment extends Fragment{

    private String[] conjugationTable, habenTable, seinTable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conjugationTable = getResources().getStringArray(R.array.conjugationTable);
        habenTable = getResources().getStringArray(R.array.conjugationHaben);
        seinTable = getResources().getStringArray(R.array.conjugationSein);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conjugation, container, false);
        Table table = new Table();
        table.setSpellFirstWordOnly(true);
        table.setTableItemHeight(55);
        table.setTextSize(17);
        new TableService(table).createRows(conjugationTable, R.id.conjugationTable, view, this.getActivity());

        table.setSpellFirstWordOnly(false);
        table.setSingleColumnFlag(true);
        table.setTableItemHeight(35);
        new TableService(table).createRows(habenTable, R.id.conjugationHabenTable, view, this.getActivity());

        new TableService(table).createRows(seinTable, R.id.conjugationSeinTable, view, this.getActivity());
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}