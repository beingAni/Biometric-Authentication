package com.example.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

    EditText e1,e2,e3,e4;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.EditText01);
        e3=(EditText)findViewById(R.id.EditText02);
        e4=(EditText)findViewById(R.id.EditText03);

        b1=(Button)findViewById(R.id.button1);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e3.getText().toString().isEmpty() || e4.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "plz enter the region ", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent in = new Intent(Register.this, Password.class);

                    String a = e1.getText().toString();
                    String b = e2.getText().toString();
                    String c = e3.getText().toString();
                    String d = e4.getText().toString();

                    in.putExtra("a", a);
                    in.putExtra("b", b);
                    in.putExtra("c", c);
                    in.putExtra("d", d);

                    startActivity(in);

                }
            }
            });
                }



    }



