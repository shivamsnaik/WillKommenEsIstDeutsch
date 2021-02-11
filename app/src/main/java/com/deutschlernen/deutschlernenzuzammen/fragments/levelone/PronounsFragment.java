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
import com.deutschlernen.deutschlernenzuzammen.service.TableService;

public class PronounsFragment extends Fragment{

    private String[] pronouns;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pronouns = getResources().getStringArray(R.array.pronouns);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pronouns, container, false);

        new TableService().createRows(pronouns, R.id.pronounsTable, view, this.getActivity(), true);
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
