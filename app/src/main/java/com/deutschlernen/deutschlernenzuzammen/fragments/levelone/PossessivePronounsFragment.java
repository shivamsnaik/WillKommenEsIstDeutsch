package com.deutschlernen.deutschlernenzuzammen.fragments.levelone;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.model.Table;
import com.deutschlernen.deutschlernenzuzammen.service.TableService;

import static android.view.View.GONE;

public class PossessivePronounsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private String[] possessivePronounsTable;
    private View view,previousTableView;
    private SeekBar seekbar;
    private TableLayout tableLayout;
    private int previousTable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        possessivePronounsTable = getResources().getStringArray(R.array.possessivePronouns);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_possessive_pronouns, container, false);
        seekbar = (SeekBar)view.findViewById(R.id.possessivePronounsSeekBar);
        seekbar.setOnSeekBarChangeListener(this);

        //SET FIRST TABLE VISIBLE BY DEFAULT
        ((ViewStub)  view.findViewById(R.id.meinTable)).setVisibility(View.VISIBLE);
        previousTable = R.id.meinTable;

        Table table = new Table();
        table.setSpellFirstWordOnly(true);
        table.setTableItemHeight(70);
        table.setTextSize(18);

        new TableService(table).createRows(possessivePronounsTable, R.id.possessivePronounsTable, view, this.getActivity());
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (progress){
            case 0:
                (view.findViewById(R.id.meinTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.meinTable;
                break;
            case 1:
                (view.findViewById(R.id.deinTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.deinTable;
                break;
            case 2:
                (view.findViewById(R.id.seinTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.seinTable;
                break;
            case 3:
                (view.findViewById(R.id.ihrTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.ihrTable;
                break;
            case 4:
                (view.findViewById(R.id.unserTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.unserTable;
                break;
            case 5:
                (view.findViewById(R.id.euerTable)).setVisibility(View.VISIBLE);
                (view.findViewById(previousTable)).setVisibility(View.GONE);
                previousTable = R.id.euerTable;
                break;
        }
    }

    private void disableOrEnableTable(int tableIndex, int visibilityValue){
        
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}