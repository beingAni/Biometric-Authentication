package com.example.bioauthentication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;





public class DrawReg extends Activity {
    float xAxis = 0f;
    float yAxis = 0f;

    float lastXAxis = 0f;
    float lastYAxis = 0f;

    TextView ed1, ed2, ed3, ed4,t1,t2,t3,t4,t5,t6;
    ImageView tv1;

    String aa=null;
    String bb=null;
    String cc=null;
    String dd=null;

    String g1,g2,m;

    SQLiteHelper sq;
    Button b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_reg);

        ed1 = (TextView) findViewById(R.id.TextView01);
        ed2 = (TextView) findViewById(R.id.TextView02);
        ed3 = (TextView) findViewById(R.id.TextView03);
        ed4 = (TextView) findViewById(R.id.TextView04);

        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.TextView05);

        t3=(TextView)findViewById(R.id.TextView06);
        t4=(TextView)findViewById(R.id.TextView07);
        t5=(TextView)findViewById(R.id.TextView08);

       // t6=(TextView)findViewById(R.id.textView2);

        b1=(Button)findViewById(R.id.button1);


        Intent i=getIntent();



        sq=new SQLiteHelper(this);


        aa=i.getStringExtra("a");
        bb=i.getStringExtra("b");
        cc=i.getStringExtra("c");
        dd=i.getStringExtra("d");

    /*  t3.setText(aa);
      t4.setText(bb);
      t5.setText(cc);*/


        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                String a=t1.getText().toString();
                String b=t2.getText().toString();


                String name=aa;
                String username=bb;
                String password=a+"-"+b;
                String email=cc;
                String mobile=dd;


                int r=sq.insertData(name, username, password, email, mobile);
                Intent i=new Intent(DrawReg.this,Home.class);
                startActivity(i);

            }
        });


        tv1=(ImageView)findViewById(R.id.imageView1);
        tv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int actionPeformed = event.getAction();

                switch(actionPeformed){
                    case MotionEvent.ACTION_DOWN:{
                        final float x = event.getX();
                        final float y = event.getY();

                        lastXAxis = x;
                        lastYAxis = y;

                        ed1.setText(Float.toString(lastXAxis));
                        ed2.setText(Float.toString(lastYAxis));


                        if ((event.getX() >= 47 && event.getX() <= 177)&&(event.getY() >= 114 && event.getY() <= 267)) {


                            t1.setText("a");

                        }

                        else if ((event.getX() >= 244 && event.getX() <= 389)&&(event.getY() >= 94 && event.getY() <= 274)) {



                            t1.setText("b");

                        }

                        else if ((event.getX() >= 438 && event.getX() <= 574)&&(event.getY() >= 143 && event.getY() <= 219)) {



                            t1.setText("c");

                        }
                        else if ((event.getX() >= 38 && event.getX() <= 182)&&(event.getY() >= 305 && event.getY() <= 461)) {



                            t1.setText("d");

                        }

                        else if ((event.getX() >= 236 && event.getX() <= 390)&&(event.getY() >= 314 && event.getY() <= 413)) {



                            t1.setText("e");

                        }


                        else if ((event.getX() >= 434 && event.getX() <= 567)&&(event.getY() >= 319 && event.getY() <= 319)) {



                            t1.setText("f");



                        }




                        if ((event.getX() >= 51 && event.getX() <= 171)&&(event.getY() >= 494 && event.getY() <= 591)) {


                            t1.setText("g");

                        }

                        else if ((event.getX() >= 244 && event.getX() <= 370)&&(event.getY() >= 490 && event.getY() <= 668)) {



                            t1.setText("h");

                        }

                        else if ((event.getX() >= 430 && event.getX() <= 591)&&(event.getY() >= 488 && event.getY() <= 599)) {



                            t1.setText("i");

                        }
                        else if ((event.getX() >= 42 && event.getX() <= 166)&&(event.getY() >= 654 && event.getY() <= 810)) {



                            t1.setText("j");

                        }
                        else if ((event.getX() >= 229 && event.getX() <= 373)&&(event.getY() >= 651 && event.getY() <= 805)) {



                            t1.setText("k");



                        }





                        else if ((event.getX() >= 419 && event.getX() <= 560)&&(event.getY() >= 667 && event.getY() <= 783)) {



                            t1.setText("l");

                        }




                        break;
                    }

                    case MotionEvent.ACTION_MOVE:{
                        final int x = (int) event.getRawX();
                        final int y = (int) event.getRawY();

                 /* final float dx = x - lastXAxis;
                  final float dy = y - lastYAxis;

                  xAxis += dx;
                  yAxis += dy;*/


                        lastXAxis = x;
                        lastYAxis = y;


                        ed3.setText(Float.toString(lastXAxis));
                        ed4.setText(Float.toString(lastYAxis));




                        if ((event.getRawX() >= 113 && event.getRawX() <= 245)&&(event.getRawY() >= 329 && event.getRawY() <= 484)) {


                            t2.setText("a");

                        }

                        else if ((event.getRawX() >= 308 && event.getRawX() <= 447)&&(event.getRawY() >= 315 && event.getRawY() <= 489)) {



                            t2.setText("b");

                        }

                        else if ((event.getRawX() >= 511 && event.getRawX() <= 636)&&(event.getRawY() >= 358 && event.getRawY() <= 495)) {



                            t2.setText("c");

                        }
                        else if ((event.getRawX() >= 102 && event.getRawX() <= 246)&&(event.getRawY() >= 520 && event.getRawY() <= 676)) {



                            t2.setText("d");

                        }
                        else if ((event.getRawX() >= 300 && event.getRawX() <= 454)&&(event.getRawY() >= 529 && event.getRawY() <= 628)) {



                            t2.setText("e");



                        }




                        if ((event.getRawX() >= 498 && event.getRawX() <= 632)&&(event.getRawY() >= 534 && event.getRawY() <= 654)) {


                            t2.setText("f");

                        }

                        else if ((event.getRawX() >= 110 && event.getRawX() <= 233)&&(event.getRawY() >= 707 && event.getRawY() <= 807)) {



                            t2.setText("g");

                        }

                        else if ((event.getRawX() >= 308 && event.getRawX() <= 434)&&(event.getRawY() >= 705 && event.getRawY() <= 864)) {



                            t2.setText("h");

                        }
                        else if ((event.getRawX() >=494 && event.getRawX() <= 655)&&(event.getRawY() >= 705 && event.getRawY() <= 819)) {



                            t2.setText("i");

                        }


                        else if ((event.getRawX() >= 105 && event.getRawX() <= 218)&&(event.getRawY() >= 872 && event.getRawY() <= 1024)) {



                            t2.setText("j");

                        }
                        else if ((event.getRawX() >= 290 && event.getRawX() <= 437)&&(event.getRawY() >= 882 && event.getRawY() <= 1023)) {



                            t2.setText("k");



                        }





                        else if ((event.getRawX() >= 483 && event.getRawX() <= 624)&&(event.getRawY() >= 890 && event.getRawY() <= 1034)) {



                            t2.setText("l");

                        }






                        break;
                    }
                }
                return true;
            }
        });



    }


   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
