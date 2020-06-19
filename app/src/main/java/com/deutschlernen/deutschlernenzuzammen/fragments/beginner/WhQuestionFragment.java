package com.deutschlernen.deutschlernenzuzammen.fragments.beginner;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.service.TableRows;


public class WhQuestionFragment extends Fragment {

    String[] whQuestionsList;
    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        whQuestionsList = getResources().getStringArray(R.array.whQuestions);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){

        View view = inflater.inflate(R.layout.fragment_wh_questions, container, false);
        new TableRows().createRows(whQuestionsList, R.id.whQuestionsTable, view, this.getActivity());

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
