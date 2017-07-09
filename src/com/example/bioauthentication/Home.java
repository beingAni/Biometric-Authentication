package com.example.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.Button01);


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(Home.this,Login.class);
                startActivity(in);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(Home.this,Register.class);
                startActivity(in);

            }
        });

    }

   

}
