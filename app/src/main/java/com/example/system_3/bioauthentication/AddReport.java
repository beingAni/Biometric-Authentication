package com.example.system_3.bioauthentication;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;




import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddReport extends Activity implements OnClickListener{

    private SQLiteHelper SQLHelper;
    private int spinner1,spinner2;
    String si;
    Button dob;
    Button view;
    Button submit;
    TextView ab,t1;
    EditText expense,amount,qty,e1,e2;
    static final int DATE_DIALOG_ID = 0;

    private EditText mDateDisplayAnnivarsary;
    private Integer mYear;
    private Integer mMonth;
    private Integer mDay;
    private Button mPickDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_report);
        String[] s = new String[] { "1", "2", "3", "4",
                "5", "6", "7", "8", "9", "10", "11", "12" };
        //final Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, s);
		/*sp1.setAdapter(adapter);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
*/
		/*	@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				si=sp1.getSelectedItem().toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub


			}
		});*/

        SQLHelper = new SQLiteHelper(this);
        dob= (Button)findViewById(R.id.dob_button);
        expense=(EditText)findViewById(R.id.expense_details);
        amount=(EditText)findViewById(R.id.amount_details);
        qty=(EditText)findViewById(R.id.EditText01);
        e1=(EditText)findViewById(R.id.EditText02);
        // e2=(EditText)findViewById(R.id.EditText03);

        t1=(TextView)findViewById(R.id.TextView01);
        view= (Button)findViewById(R.id.button3);
        ab=(TextView)findViewById(R.id.textView1);
        submit= (Button)findViewById(R.id.button1);
        submit.setOnClickListener(this);
		/*submit1= (Button)findViewById(R.id.button2);
		submit1.setOnClickListener(this);*/
        mPickDate= (Button) findViewById(R.id.dob_button);
        mPickDate.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });


        view.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(AddReport.this,
                        MainActivity.class);
                startActivity(i);

            }
        });


        Calendar c1 = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat(" h:m:s a");
        sdf1.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        String strdate1 = sdf1.format(c1.getTime());


        t1.setText(strdate1);



        //submit.setOnClickListener(new OnClickListener() {




        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mPickDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append("Date: ")
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
    }
    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener,mYear, mMonth, mDay);
        }
        return null;

    }
    private void updateDisplay() {
        System.out.println("year "+mYear);
        System.out.println("month "+mMonth);
        System.out.println("date "+mDay);
        mPickDate.setText(
                new StringBuilder()
                        // Month is 0 based so add 1
                        .append("Date : ")
                        .append(mMonth + 1).append("-")
                        .append(mDay).append("-")
                        .append(mYear).append(" "));
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId())
        {
            case R.id.button1:

                int a=mMonth+1;
                int b=mDay;
                int c1=mYear;

                String month=Integer.toString(a);
                String date=Integer.toString(b);
                String year=Integer.toString(c1);
                String dob=month+"-"+date+"-"+year;
                String j=expense.getText().toString();
                String m=amount.getText().toString();
                String n=qty.getText().toString();
                String o=e1.getText().toString();
                String p=t1.getText().toString();
                String ate=year+"-"+month;

                if(j.equals(""))
                {
                    Toast.makeText(this, "Enter expense details", Toast.LENGTH_SHORT).show();
                }
                else if(m.equals(""))
                {
                    Toast.makeText(this, "Enter expense amount", Toast.LENGTH_SHORT).show();
                }

                else if(n.equals(""))
                {
                    Toast.makeText(this, "Enter quantity",Toast.LENGTH_SHORT).show();
                }
                else
                {


                    String ss=SQLHelper.insertData1(j,dob,m,n,o,p,ate);
                    if(ss.equals("success"))
                    {

                        Toast.makeText(this, "Successfully Registerd", Toast.LENGTH_SHORT).show();
                        expense.setText(" ");
                        amount.setText("");
                    }}

                Intent i = new Intent(AddReport.this,
                        Home.class);
                startActivity(i);
                //ab.setText(dob);
                break;

				/*	case R.id.button2:

						 String j1=incomeamt.getText().toString();
					        String m1=budgetamt.getText().toString();


					        final Calendar c = Calendar.getInstance();
					        mYear = c.get(Calendar.YEAR);
					        String y1=Integer.toString(mYear);
					        String dob1=si+"-"+y1;
					        if(j1.equals(""))
							{
								Toast.makeText(this, "Enter income", 10).show();
							}
							else if(m1.equals(""))
							{
								Toast.makeText(this, "Enter budget", 10).show();
							}
							else



						 String sss=SQLHelper.insertData2(dob1,j1,m1);
						 if(sss.equals("success"))
					       {

							Toast.makeText(this, "Successfully updated", 10).show();


							incomeamt.setText(" ");
							budgetamt.setText(" ");

					       }}
						 break;*/
        }

    }

}

