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

public class DativVerbenFragment extends Fragment {

    String[] dativeVerbsList;
    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        dativeVerbsList = getResources().getStringArray(R.array.dativeVerbs);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){

        View view = inflater.inflate(R.layout.fragment_dativ_verben, container, false);
        new TableService().createRows(dativeVerbsList, R.id.dativeVerbenTable, view, this.getActivity());
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
