package com.deutschlernen.deutschlernenzuzammen.service;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;

import com.android.deutschlernenzuzammen.R;
import com.deutschlernen.deutschlernenzuzammen.model.Table;

import org.w3c.dom.Text;

public class TableService {

    private Table tableProperties;
    public TableService(){tableProperties = new Table();}
    public TableService(Table table){this.tableProperties = table;}

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void createRows(String[] dataList, int tableId, View view, Activity fragmentActivity){

        //THE DISPLAY SCALE FACTOR
        final float scale = view.getContext().getResources().getDisplayMetrics().density;

        //Fetches the resources with the help of Attributes
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = view.getContext().getTheme();
        theme.resolveAttribute(R.attr.ElementColorEight, typedValue,  true);
        final int textColor = ColorService.getColor(view.getContext(), R.attr.TableTextColor);

        TableLayout table = (TableLayout)  view.findViewById(tableId);

        int counterRange = 2, listLengthFix = 1;
        if(true == tableProperties.getSingleColumnFlag()){
            counterRange = 1;
            listLengthFix = 0;
        }
        for(int i=0; i<dataList.length-listLengthFix; i+=counterRange){

            if(dataList[i].equals("-- LINE_BREAK --")){
                TableRow row = new TableRow(fragmentActivity);
                row.setElevation(10);
                row.setTranslationZ(20);
                row.setStateListAnimator(null);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, (int)(2 * scale + 0.5)));
                row.setBackgroundResource(R.color.white);

                TextView emptyTextView = new TextView(fragmentActivity);
                emptyTextView.setHeight((int)(2 * scale + 0.5f));
                row.addView(emptyTextView);
                table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                i++;
            }

            TableRow row = new TableRow(fragmentActivity);
            row.setElevation(10);
            row.setTranslationZ(20);
            row.setStateListAnimator(null);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            row.setMinimumHeight((int) (tableProperties.getTableItemHeight() * scale + 0.5));
            row.setBackgroundResource(R.drawable.grid_background);

            TextView firstTextView = new TextView(fragmentActivity);
            firstTextView.setGravity(Gravity.CENTER);
            firstTextView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            firstTextView.setText(dataList[i]);
            firstTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            firstTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tableProperties.getTextSize());
//            TextViewCompat.setTextAppearance(txtViewGerman, R.style.GidoleRegularFont);
            firstTextView.setTextColor(textColor);
            firstTextView.setBackgroundResource(R.drawable.ripple_table_item_background);
            firstTextView.setOnClickListener(new TextToSpeechListener(tableProperties.getIsSpellFirstWordOnly()));
            row.addView(firstTextView);

            if(true != tableProperties.getSingleColumnFlag()) {
                TextView secondTextView = new TextView(fragmentActivity);
                secondTextView.setGravity(Gravity.CENTER);
                secondTextView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
                secondTextView.setText(dataList[i + 1]);
                secondTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                secondTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tableProperties.getTextSize());
                //            TextViewCompat.setTextAppearance(txtViewEnglish, R.style.GidoleRegularFont);
                secondTextView.setTextColor(textColor);
                secondTextView.setBackgroundResource(R.drawable.ripple_table_item_background);
                secondTextView.setOnClickListener(null);
                row.addView(secondTextView);
            }

            table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    //To check whether only the first word from the string is to be sent to tts service
    private static boolean getFirstWordFlag(int fragmentId){
        System.out.println("FRAGMENT ID: "+fragmentId);
        boolean flag = false;
        switch (fragmentId){
            case R.layout.fragment_conjugation:
                flag = true;
                break;
            default: flag = false;
        }
        System.out.println("FRAGMENT ID: "+fragmentId);
        return flag;
    }

    class TextToSpeechListener implements TextView.OnClickListener {
        private boolean firstWordOnly = false;

        public TextToSpeechListener(){}

        public TextToSpeechListener(boolean flag) {firstWordOnly = flag;}

        @Override
        public void onClick(View v) {
            Log.i("ONSPEECH", "onClick: "+((TextView)v).getText());
            if(false == firstWordOnly){
                TextToSpeechService.convertTextToSpeech(v.getContext(), ((TextView)v).getText());
            }else if(true == firstWordOnly){
                TextToSpeechService.convertTextToSpeech(v.getContext(), ((TextView)v).getText().toString().split("\\s+")[0]);
            }
        }
    }

}
