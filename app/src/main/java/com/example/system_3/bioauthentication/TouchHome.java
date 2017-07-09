package com.example.system_3.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class TouchHome extends Activity {

    Button b1,b2,b3;

    String aa=null;
    String bb=null;
    String cc=null;
    String dd=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_home);

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.Button01);
        b3=(Button)findViewById(R.id.Button02);


        Intent i = getIntent();
        aa = i.getStringExtra("a");
        bb= i.getStringExtra("b");
        cc= i.getStringExtra("c");
        dd= i.getStringExtra("d");

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent in=new Intent(TouchHome.this,ImageReg.class);

                in.putExtra("a", aa);
                in.putExtra("b", bb);
                in.putExtra("c", cc);
                in.putExtra("d", dd);


                startActivity(in);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                Intent in=new Intent(TouchHome.this,DrawReg.class);

                in.putExtra("a", aa);
                in.putExtra("b", bb);
                in.putExtra("c", cc);
                in.putExtra("d", dd);


                startActivity(in);


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

            }
        });

        Intent in=new Intent(TouchHome.this,PatternReg.class);

        in.putExtra("a", aa);
        in.putExtra("b", bb);
        in.putExtra("c", cc);
        in.putExtra("d", dd);


        startActivity(in);
    }



}
