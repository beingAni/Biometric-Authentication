package com.example.system_3.bioauthentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home3 extends AppCompatActivity {

    Button b1,b2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in = new Intent(Home3.this, AddReport.class);
                startActivity(in);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in = new Intent(Home3.this, ViewReport.class);
                startActivity(in);

            }
        });

    }



}



