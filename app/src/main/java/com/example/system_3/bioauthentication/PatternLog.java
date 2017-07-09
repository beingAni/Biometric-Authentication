package com.example.system_3.bioauthentication;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.system_3.bioauthentication.utils.Lock9View;

public class PatternLog extends ActionBarActivity {

    private Lock9View lock9View;

    private static String MY_PREFS_NAME = "PatternLock";
    private static String PATTERN_KEY;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pattern_log);

        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        lock9View = (Lock9View) findViewById(R.id.lock_9_view);

        lock9View.setCallBack(new Lock9View.CallBack() {

            @Override
            public void onFinish(String password) {
                PATTERN_KEY = prefs.getString("Pattern", "invalid");

                if(PATTERN_KEY.equals("invalid")){
                    Toast.makeText(PatternLog.this, "Options --> Create new Pattern", Toast.LENGTH_LONG).show();
                }else{
                    if(password.equals(PATTERN_KEY)){
                        Intent intent = new Intent(PatternLog.this, Home3.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(PatternLog.this, "Login success!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(PatternLog.this, "Pattern incorrect!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contact:
                new AlertDialog.Builder(this)
                        .setTitle("Android-Lock9View")
                        .setMessage(
                                "Email : anfersyed@gmail.com\n" +
                                        "Blog  : http://android-delight.blogspot.in/\n")
                        .setPositiveButton("OK", null)
                        .show();
                return true;

            case R.id.create_new_pattern:
                Intent intent = new Intent(PatternLog.this, PatternReg.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
