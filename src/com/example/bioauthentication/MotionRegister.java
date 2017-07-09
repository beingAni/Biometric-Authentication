package com.example.bioauthentication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MotionRegister extends Activity implements SensorEventListener {
    private SensorManager sensorManager;

    TextView xCoor; // declare X axis object
    TextView yCoor; // declare Y axis object
    TextView zCoor; // declare Z axis object

    TextView t1;

    SQLiteHelper sq;

    String aa=null;
    String bb=null;
    String cc=null;
    String dd=null;

    Button b1;



    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_register);

        xCoor=(TextView)findViewById(R.id.xcoor); // create X axis object
        yCoor=(TextView)findViewById(R.id.ycoor); // create Y axis object
        zCoor=(TextView)findViewById(R.id.zcoor); // create Z axis object

        t1=(TextView)findViewById(R.id.textView1);

        b1=(Button)findViewById(R.id.button1);

        sq=new SQLiteHelper(this);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        // add listener. The listener will be HelloAndroid (this) class
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);

		/*	More sensor speeds (taken from api docs)
		    SENSOR_DELAY_FASTEST get sensor data as fast as possible
		    SENSOR_DELAY_GAME	rate suitable for games
		 	SENSOR_DELAY_NORMAL	rate (default) suitable for screen orientation changes
		*/

        Intent i = getIntent();
        aa = i.getStringExtra("a");
        bb= i.getStringExtra("b");
        cc= i.getStringExtra("c");
        dd= i.getStringExtra("d");

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String name=aa;
                String username=bb;
                String password=t1.getText().toString();
                String email=cc;
                String mobile=dd;


                int r=sq.insertData(name, username, password, email, mobile);
                Intent i=new Intent(MotionRegister.this,Home.class);
                startActivity(i);

            }
        });



    }

    public void onAccuracyChanged(Sensor sensor,int accuracy){

    }

    public void onSensorChanged(SensorEvent event){

        // check sensor type
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){

            // assign directions
            float x=event.values[0];
            float y=event.values[1];
            float z=event.values[2];

            int i,j,k;

            i = (int)x;
            j = (int)y;
            k = (int)z;

            xCoor.setText("X: "+i);
            yCoor.setText("Y: "+j);
            zCoor.setText("Z: "+k);


            if ((i <= 7 && i >= 3 )&&(j >= 0 && j <= 1 )&&(k >=5 && k <= 8)) {


                t1.setText("a");


            }

            if ((i <= 3 && i >= 0 )&&(j >= 0 && j <= 1 )&&(k >=8 && k <= 9)) {


                t1.setText("b");


            }
            if ((i <= 0 && i >= -5 )&&(j >= 1 && j <= 2 )&&(k >=6 && k <= 9)) {


                t1.setText("c");


            }

            if ((i <= 0 && i >= 0 )&&(j >= -6 && j <= 0 )&&(k >=7 && k <= 9)) {


                t1.setText("d");


            }



            if ((i <= 0 && i >= 0 )&&(j >= 0 && j <= 3 )&&(k >=8 && k <= 9)) {


                t1.setText("e");


            }

            if ((i <= 1 && i >= 0 )&&(j >= 3 && j <= 8 )&&(k >=5 && k <= 9)) {


                t1.setText("f");


            }
            if ((i <= 2 && i >= 0 )&&(j >= 9 && j <= 9 )&&(k >=-3 && k <= -1)) {


                t1.setText("g");


            }

            if ((i <= 0 && i >= 0 )&&(j >= 9 && j <= 9 )&&(k >=-3 && k <= -1)) {


                t1.setText("h");


            }

            if ((i <= 0 && i >= -1 )&&(j >= 9 && j <= 9 )&&(k >=-3 && k <= -1)) {


                t1.setText("i");


            }




        }
    }
}
