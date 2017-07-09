package com.example.system_3.bioauthentication;





import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ImageLog extends Activity implements OnClickListener {


    TextView t1,t2,t3,t4,t5,t6,t7;

    String aa=null;
    String bb=null;
    String cc=null;
    String dd=null;

    private SQLiteHelper SQLHelper;


    Button b1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_log);

        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.TextView01);
        t3=(TextView)findViewById(R.id.TextView02);
        //t4=(TextView)findViewById(R.id.TextView03);
        t5=(TextView)findViewById(R.id.TextView04);
        //t6=(TextView)findViewById(R.id.TextView05);
        //t7=(TextView)findViewById(R.id.TextView06);

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);

        SQLHelper = new SQLiteHelper(this);

        Intent i = getIntent();
        aa = i.getStringExtra("a");


		/*t4.setText(aa);
		t5.setText(bb);
		t6.setText(cc)*/;

		/**/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if ((event.getX() >= 255 && event.getX() <= 351)&&(event.getY() >= 545 && event.getY() <= 588)) {


            t3.setText("a");

        }

        else if ((event.getX() >= 263 && event.getX() <= 324)&&(event.getY() >= 560 && event.getY() <= 630)) {



            t3.setText("b");

        }

        else if ((event.getX() >= 403 && event.getX() <= 477)&&(event.getY() >= 510 && event.getY() <= 565)) {



            t3.setText("c");

        }
        else if ((event.getX() >= 404 && event.getX() <= 476)&&(event.getY() >= 594 && event.getY() <= 624)) {



            t3.setText("d");

        }
        else if ((event.getX() >= 263 && event.getX() <= 321)&&(event.getY() >= 689 && event.getY() <= 759)) {



            t3.setText("e");



        }

        else if ((event.getX() >= 345 && event.getX() <= 417)&&(event.getY() >= 655 && event.getY() <= 763)) {



            t3.setText("f");
        }


        else if ((event.getX() >= 447 && event.getX() <= 502)&&(event.getY() >= 659 && event.getY() <= 817)) {



            t3.setText("g");

        }

        else if ((event.getX() >= 339 && event.getX() <= 452)&&(event.getY() >= 715 && event.getY() <= 854)) {



            t3.setText("h");

        }
        else if ((event.getX() >= 240 && event.getX() <=318)&&(event.getY() >= 790 && event.getY() <= 967)) {



            t3.setText("i");

        }
        else if ((event.getX() >= 530 && event.getX() <= 547)&&(event.getY() >= 545 && event.getY() <= 643)) {


            t3.setText("j");

        }
        else if ((event.getX() >= 529 && event.getX() <= 581)&&(event.getY() >= 709 && event.getY() <= 1086)) {



            t3.setText("k");

        }

        else  {



            t3.setText("l");

        }













        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                String h=null;
                String g=null;

                h=aa;
                g=t3.getText().toString();



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

                        Intent i = new Intent(ImageLog.this,
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
