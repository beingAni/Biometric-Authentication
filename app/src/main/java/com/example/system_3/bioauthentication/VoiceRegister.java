package com.example.system_3.bioauthentication;

import java.util.ArrayList;
import java.util.Locale;




import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VoiceRegister extends Activity implements TextToSpeech.OnInitListener{

    TextView e1;
    Button speak,b1;
    private final int a1 = 50;
    private TextToSpeech textToSpeech;

    SQLiteHelper sq;

    String aa=null;
    String bb=null;
    String cc=null;
    String dd=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_register);


        e1=(TextView)findViewById(R.id.textView1);
        speak=(Button)findViewById(R.id.button1);

        sq=new SQLiteHelper(this);


        b1=(Button)findViewById(R.id.Button01);

        Intent i = getIntent();
        aa = i.getStringExtra("a");
        bb= i.getStringExtra("b");
        cc= i.getStringExtra("c");
        dd= i.getStringExtra("d");


        speak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput1();
            }

        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub



                String name=aa;
                String username=bb;
                String password=e1.getText().toString();
                String email=cc;
                String mobile=dd;

                if (e1.getText().toString().isEmpty()) {
                    Toast.makeText(VoiceRegister.this, "plz enter the region ", Toast.LENGTH_SHORT).show();
                    return;
                } else {


                int r=sq.insertData(name, username, password, email, mobile);
                Intent i=new Intent(VoiceRegister.this,Home.class);
                startActivity(i);
                }
            }
        });
    }





    protected void promptSpeechInput1() {
        // TODO Auto-generated method stub
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,getString(R.string.speech_prompt));
        try
        {
            startActivityForResult(intent, a1);
        }
        catch (ActivityNotFoundException a)
        {
            Toast.makeText(getApplicationContext(),getString(R.string.speech_not_supported),Toast.LENGTH_SHORT).show();
        }
    }




    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Log.e("error", "This Language is not supported");
            }
            else
            {
                //convertTextToSpeech();
            }
        }
        else
        {
            Log.e("error", "Initilization Failed!");
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case a1:
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                e1.setText(result.get(0));
                break;



        }
    }


}
