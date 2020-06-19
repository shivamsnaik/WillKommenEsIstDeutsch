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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;

import com.android.deutschlernenzuzammen.R;

import org.w3c.dom.Text;

public class TableRows {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void createRows(String[] dataList, int tableId, View view, Activity fragmentActivity){

        //THE DISPLAY SCALE FACTOR
        final float scale = view.getContext().getResources().getDisplayMetrics().density;

        //Fetches the resources with the help of Attributes
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = view.getContext().getTheme();
        theme.resolveAttribute(R.attr.ElementColorEight, typedValue,  true);
        final int textColor = ColorService.getColor(view.getContext(), R.attr.TableTextColor);

        //Check whether only first word is to be sent to tts service
        boolean spellFirstWordOnly = TableRows.getFirstWordFlag(view.getId());

        TableLayout table = (TableLayout)  view.findViewById(tableId);
        for(int i=0; i<dataList.length-1; i+=2){

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
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, (int) (90 * scale + 0.5)));
            row.setBackgroundResource(R.drawable.grid_background);

            TextView txtViewGerman = new TextView(fragmentActivity);
            txtViewGerman.setGravity(Gravity.CENTER);
            txtViewGerman.setHeight((int)(90 * scale + 0.5f)); //SET HEIGHT IN DP
            txtViewGerman.setText(dataList[i]);
            txtViewGerman.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            txtViewGerman.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
//            TextViewCompat.setTextAppearance(txtViewGerman, R.style.GidoleRegularFont);
            txtViewGerman.setTextColor(textColor);
            txtViewGerman.setBackgroundResource(R.drawable.ripple_table_item_background);
            txtViewGerman.setOnClickListener(new TextToSpeechListener(spellFirstWordOnly));

            TextView  txtViewEnglish = new TextView(fragmentActivity);
            txtViewEnglish.setGravity(Gravity.CENTER);
            txtViewEnglish.setHeight((int)(90 * scale + 0.5f)); //SET HEIGHT IN DP
            txtViewEnglish.setText(dataList[i+1]);
            txtViewEnglish.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            txtViewEnglish.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
//            TextViewCompat.setTextAppearance(txtViewEnglish, R.style.GidoleRegularFont);
            txtViewEnglish.setTextColor(textColor);
            txtViewEnglish.setBackgroundResource(R.drawable.ripple_table_item_background);
            txtViewEnglish.setOnClickListener(null);

            row.addView(txtViewGerman);
            row.addView(txtViewEnglish);
            table.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }
    }

    //To check whether only the first word from the string is to be sent to tts service
    private static boolean getFirstWordFlag(int fragmentId){

        boolean flag;
        switch (fragmentId){
            case R.layout.fragment_conjugation:
                flag = true;
                break;
            default: flag = false;
        }

        return flag;
    }

    static class TextToSpeechListener implements TextView.OnClickListener {
        private boolean firstWordOnly = false;

        public TextToSpeechListener(){}

        public TextToSpeechListener(boolean flag) {firstWordOnly = true;}

        @Override
        public void onClick(View v) {
            Log.i("ONSPEECH", "onClick: "+((TextView)v).getText());
            if(false == firstWordOnly){
                TextToSpeechService.convertTextToSpeech(v.getContext(), ((TextView)v).getText());
            }else{
                TextToSpeechService.convertTextToSpeech(v.getContext(), ((TextView)v).getText().toString().split("\\s+")[0]);
            }
        }
    }

}
