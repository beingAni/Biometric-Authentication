package com.example.system_3.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TouchHome1 extends Activity {


    Button b1,b2,b3;

    String aa=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_home1);


        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.Button01);
        b3=(Button)findViewById(R.id.Button02);

        Intent i = getIntent();
        aa = i.getStringExtra("a");


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                Intent in=new Intent(TouchHome1.this,ImageLog.class);
                in.putExtra("a", aa);

                startActivity(in);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(TouchHome1.this,DrawLog.class);
                in.putExtra("a", aa);

                startActivity(in);


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(TouchHome1.this,PatternLog.class);
                in.putExtra("a", aa);

                startActivity(in);


            }
        });

    }



}
