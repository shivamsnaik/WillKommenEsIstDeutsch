package com.deutschlernen.deutschlernenzuzammen.service;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public final class TextToSpeechService {


    private static TextToSpeech textToSpeechObj;

    public static void convertTextToSpeech(Context context, CharSequence text){

        if(text.length() <=0)
        {
            Toast.makeText(context, "No content found to SPEAK.", Toast.LENGTH_SHORT).show();
            return;
        }
        textToSpeechObj = new TextToSpeech(context, new TextToSpeech.OnInitListener() {

            Voice voice = new Voice("es-us-x-sfb-local",Locale.GERMAN, Voice.QUALITY_HIGH, Voice.LATENCY_VERY_LOW, false, null);

            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    Log.i("ONSPEECH", "onInit: "+status);
                    int result = textToSpeechObj.setLanguage(Locale.GERMAN);
                    textToSpeechObj.setVoice(voice);
                    textToSpeechObj.setSpeechRate(0.9f);
                    if(result == TextToSpeech.LANG_MISSING_DATA ||
                    result  == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(context, "This language is not supported", Toast.LENGTH_SHORT).show();
                    }else{
                        textToSpeechObj.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }

            }
        });

    }
}
