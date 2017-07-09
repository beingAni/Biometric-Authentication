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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VoiceLogin extends Activity implements TextToSpeech.OnInitListener,OnClickListener{

    TextView e1;
    Button speak,b1;
    private final int a1 = 50;
    private TextToSpeech textToSpeech;

    private SQLiteHelper SQLHelper;

    String aa=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_login);

        SQLHelper = new SQLiteHelper(this);
        e1=(TextView)findViewById(R.id.textView1);
        speak=(Button)findViewById(R.id.button1);

        b1=(Button)findViewById(R.id.Button01);
        b1.setOnClickListener(this);

        speak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput1();
            }

        });

        Intent i = getIntent();
        aa = i.getStringExtra("a");


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

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.Button01:
                String h=null;
                String g=null;

                h=aa;
                g=e1.getText().toString();



                if(h.equals(""))
                {

                    Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_SHORT).show();


                }
                else if(g.equals(""))
                {
                    Toast.makeText(this, "Enter password", 10).show();
                }

                else

                {


                    String sss=SQLHelper.loginData1(h,g);

                    if(sss.equals("fail"))
                    {
                        Toast.makeText(this, sss, 10).show();
                    }else
                    {

                        Intent i = new Intent(VoiceLogin.this,
                                Home3.class);
                        startActivity(i);

                    }

                }
                break;
		/*case R.id.button1:
			Intent i = new Intent(VoiceLogin.this,
					Register.class);
			startActivity(i);
		break;*/
		/*case R.id.button3:
			//SQLHelper.deleteAll();

			break;
		*/
        }}

}
