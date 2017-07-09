package com.example.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {

    EditText e1;

    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        e1=(EditText)findViewById(R.id.editText1);

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.Button01);
        b3=(Button)findViewById(R.id.Button02);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(Login.this,VoiceLogin.class);

                String a=e1.getText().toString();

                in.putExtra("a", a);

                startActivity(in);

            }
        });



        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(Login.this,MotionLogin.class);

                String a=e1.getText().toString();

                in.putExtra("a", a);


                startActivity(in);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(Login.this,TouchHome1.class);

                String a=e1.getText().toString();

                in.putExtra("a", a);


                startActivity(in);

            }
        });

    }



}
