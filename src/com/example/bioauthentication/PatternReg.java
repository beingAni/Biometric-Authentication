package com.example.bioauthentication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PatternReg extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pattern_reg);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pattern_reg, menu);
		return true;
	}

}
