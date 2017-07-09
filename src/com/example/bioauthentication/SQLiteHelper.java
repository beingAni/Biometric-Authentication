package com.example.bioauthentication;

import java.util.ArrayList;
import java.util.Calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper {
    public static ArrayList<String[]> DATA = new ArrayList<String[]>();
    private static final String DATABASE_NAME = "budget.db";
    private static final int DATABASE_VERSION = 1;
    private static final String STUDENT_TABLE = "user";


    private static final String STUDENT_TABLE4 = "expense";
    private static final String STUDENT_TABLE3 = "income";
    private static final String STUDENT_TABLE6 = "employereg";

    private Context context;
    private SQLiteDatabase db = null;


    OpenHelper openHelper;

    public SQLiteHelper(Context context) {
        this.context = context;

        if (db != null)
            if (db.isOpen())
                db.close();

        openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (openHelper != null) {
            openHelper.close();
        }
    }

    public int insertData(String name, String username,String password,String email,String mobile) {
        int entryId = 0;
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("username", username);

        values.put("password", password);
        values.put("email", email);
        values.put("mobile", mobile);

        entryId = (int) this.db.insert(STUDENT_TABLE, null, values);
        return entryId;
    }

    public String insertData6(String ename, String eid, String eage,String ect,String ewag) {
        // TODO Auto-generated method stub
        int entryId = 0;
        ContentValues values = new ContentValues();
        values.put("ename", ename);
        values.put("eid", eid);

        values.put("eage", eage);

        values.put("ect", ect);

        values.put("ewag", ewag);
        entryId = (int) this.db.insert(STUDENT_TABLE6, null, values);
        return "success";
    }

    public String getkey(String eid)
    {
        // TODO Auto-generated method stub
        Cursor c1 = null;

        String n2=null;

        DATA.clear();
        String[] columns = new String[] {  "ename" };

        c1 = db.query(STUDENT_TABLE6, columns,"eid=?", new String[] {eid}, null,null,null);


        if (c1.moveToNext()) {

            n2=c1.getString(0);

            Log.d(n2,"00000000000000000000");
        }
        return n2;
    }

    public String getkey1(String loca1)
    {
        // TODO Auto-generated method stub
        Cursor c1 = null;

        String n2=null;

        DATA.clear();
        String[] columns = new String[] {  "eid" };

        c1 = db.query(STUDENT_TABLE6, columns,"eid=?", new String[] {loca1}, null,null,null);


        if (c1.moveToNext()) {

            n2=c1.getString(0);

            Log.d(n2,"00000000000000000000");
        }
        return n2;
    }

    public String getkey2(String loca2)
    {
        // TODO Auto-generated method stub
        Cursor c1 = null;

        String n2=null;

        DATA.clear();
        String[] columns = new String[] {  "eage" };

        c1 = db.query(STUDENT_TABLE6, columns,"eid=?", new String[] {loca2}, null,null,null);


        if (c1.moveToNext()) {

            n2=c1.getString(0);

            Log.d(n2,"00000000000000000000");
        }
        return n2;
    }

    public String getkey3(String loca3)
    {
        // TODO Auto-generated method stub
        Cursor c1 = null;

        String n2=null;

        DATA.clear();
        String[] columns = new String[] {  "ect" };

        c1 = db.query(STUDENT_TABLE6, columns,"eid=?", new String[] {loca3}, null,null,null);


        if (c1.moveToNext()) {

            n2=c1.getString(0);

            Log.d(n2,"00000000000000000000");
        }
        return n2;
    }


    public String getkey4(String loca4)
    {
        // TODO Auto-generated method stub
        Cursor c1 = null;

        String n2=null;

        DATA.clear();
        String[] columns = new String[] {  "ewag" };

        c1 = db.query(STUDENT_TABLE6, columns,"eid=?", new String[] {loca4}, null,null,null);


        if (c1.moveToNext()) {

            n2=c1.getString(0);

            Log.d(n2,"00000000000000000000");
        }
        return n2;
    }


/*
public void deleteAll() {
deleteTable(STUDENT_TABLE);
}
public void deleteTable(String tn) {
this.db.delete(tn, null, null);
}


*/

    static class OpenHelper extends SQLiteOpenHelper {

        OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + STUDENT_TABLE + "("
                    + "id INTEGER PRIMARY KEY, " + "name TEXT, "
                    + "username TEXT, "+"password TEXT, "+"email TEXT, " + "mobile TEXT)");

            db.execSQL("CREATE TABLE " + STUDENT_TABLE3 + "("
                    + "id INTEGER PRIMARY KEY, " + "monthyear TEXT, "
                    + "incomeamt TEXT, " + "budgetamt TEXT)");
            db.execSQL("CREATE TABLE " + STUDENT_TABLE4 + "("
                    + "id INTEGER PRIMARY KEY, " + "meterial TEXT, "
                    + "datee TEXT, " + "qty TEXT," + "amount TEXT," + "receivedfrom TEXT," + "time TEXT," + "monthyear TEXT)");

            db.execSQL("CREATE TABLE " + STUDENT_TABLE6 + "("
                    + "id INTEGER PRIMARY KEY, " + "ename TEXT, "
                    + "eid TEXT, " + "eage TEXT," + "ect TEXT," + "ewag TEXT)");



        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Catch DB",
                    "Upgrading database, this will drop tables and recreate.");
            db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);

            db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE3);
            db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE4);


            db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE6);
            onCreate(db);
        }
    }





    public String loginData1(String h, String g) {
        // TODO Auto-generated method stub
        Cursor c1 = null;
        DATA.clear();
        String[] columns = new String[] {  "username" };

        c1 = db.query(STUDENT_TABLE, columns,"username=? AND password=?", new String[] {h,g}, null,null,null);
        if (c1.moveToNext()) {

            String n=c1.getString(0);
            return "true";
        }
        else
        {
            return "fail";
        }

    }

    public String insertData1(String j, String dob, String m,String n, String o,String p,String ate1) {
        // TODO Auto-generated method stub
        int entryId = 0;
        ContentValues values = new ContentValues();
        values.put("meterial", j);
        values.put("datee", dob);

        values.put("qty", m);

        values.put("amount", n);

        values.put("receivedfrom", o);

        values.put("time", p);

        values.put("monthyear", ate1);
        entryId = (int) this.db.insert(STUDENT_TABLE4, null, values);
        return "success";
    }



    public String insertData2(String dob1, String j1, String m1) {
        // TODO Auto-generated method stub
        int entryId = 0;
        ContentValues values = new ContentValues();
        values.put("monthyear", dob1);
        values.put("incomeamt", j1);

        values.put("budgetamt", m1);
        entryId = (int) this.db.insert(STUDENT_TABLE3, null, values);
        return "success";
    }

    public String selectincome(String dob) {
        // TODO Auto-generated method stub
        Cursor c1 = null;
        String n=null;
        DATA.clear();
        String[] columns = new String[] {  "incomeamt" };

        c1 = db.query(STUDENT_TABLE3, columns,"monthyear=?", new String[] {dob}, null,null,null);
        if (c1.moveToNext()) {

            n=c1.getString(0);

        }
        return n;


    }

    public String expenseincome(String dob) {
        // TODO Auto-generated method stub
        Cursor c1 = null;
        String n2=null;
        DATA.clear();
        String[] columns = new String[] {  "incomeamt" };

        c1 = db.query(STUDENT_TABLE3, columns,"monthyear=?", new String[] {dob}, null,null,null);
        if (c1.moveToNext()) {

            n2=c1.getString(0);

        }
        return n2;
    }



    public String selectbal()  {
        // TODO Auto-generated method stub
        Integer mYear;
        Integer mMonth;
        Integer mDay;
        final Calendar c2 = Calendar.getInstance();
        mYear = c2.get(Calendar.YEAR);
        mMonth = c2.get(Calendar.MONTH);
        mDay = c2.get(Calendar.DAY_OF_MONTH);
        int a=mMonth+1;
        int b=mDay;
        int c1=mYear;
        String month=Integer.toString(a);
        // String date=Integer.toString(b);
        String year=Integer.toString(c1);
        String dob2=year+"-"+month;
        Cursor c21 = null;
        String n2=null;
        DATA.clear();
        String[] columns = new String[] {  "SUM(receivedfrom)" };
        // c21 = db.query(false, "select sum(amount) from income where monthyear='"+dob2+"';", null, n2, null, n2, n2, n2, n2);
        c21 = db.query(STUDENT_TABLE4, columns,"monthyear=?", new String[] {dob2}, null,null,null);
        while (c21.moveToNext()) {

            n2=c21.getString(0);


        }
        System.out.print(n2);
        return n2;
    }


    public String selectbal1() {
        // TODO Auto-generated method stub
        Integer mYear;
        Integer mMonth;
        Integer mDay;
        final Calendar c2 = Calendar.getInstance();
        mYear = c2.get(Calendar.YEAR);
        mMonth = c2.get(Calendar.MONTH);
        mDay = c2.get(Calendar.DAY_OF_MONTH);
        int a=mMonth+1;
        int b=mDay;
        int c1=mYear;
        String month=Integer.toString(a);
        //String date=Integer.toString(b);
        String year=Integer.toString(c1);
        String dob2=year+"-"+month;
        Cursor c21 = null;
        String n2=null;
        DATA.clear();
        String[] columns = new String[] {  "SUM(receivedfrom)" };
        // c21 = db.query(false, "select sum(amount) from income where monthyear='"+dob2+"';", null, n2, null, n2, n2, n2, n2);
        c21 = db.query(STUDENT_TABLE4, columns,"qty=?", new String[] {dob2}, null,null,null);
        while (c21.moveToNext()) {

            n2=c21.getString(0);


        }
        System.out.print(n2);
        return n2;
    }

    public ArrayList<String[]> selectalldatabase1(String smf1) {
        // TODO Auto-generated method stub

        Cursor c = null;
        DATA.clear();
        String[] columns = new String[] { "id","datee", "expensed","qty", "amount" };
        c = db.query(STUDENT_TABLE6, columns,"meterial=?", new String[] {smf1},null, null, null, null);
        if (c.moveToFirst()) {
            do {
                if (c.getColumnCount() == 5) {
                    String[] str = new String[4];
                    str[0] = c.getString(1);
                    str[1] = c.getString(2);
                    str[2] = c.getString(3);
                    str[3] = c.getString(4);
                    DATA.add(str);
                }
            } while (c.moveToNext());
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }

        return DATA;
    }

    public ArrayList<String[]> selectalldatabase2(String smf) {
        // TODO Auto-generated method stub

        Cursor c1 = null;
        DATA.clear();
        String[] columns = new String[] { "id","datee", "monthyear","qty", "amount","receivedfrom", "time" };
        c1 = db.query(STUDENT_TABLE4, columns,"meterial=?", new String[] {smf},null, null, null, null);
        if (c1.moveToFirst()) {
            do {
                if (c1.getColumnCount() == 7) {
                    String[] str = new String[7];
                    str[0] = c1.getString(1);
                    str[1] = c1.getString(2);
                    str[2] = c1.getString(3);
                    str[3] = c1.getString(4);
                    str[4] = c1.getString(5);
                    str[5] = c1.getString(6);




                    DATA.add(str);
                }
            } while (c1.moveToNext());
        }

        if (c1 != null && !c1.isClosed()) {
            c1.close();
        }

        return DATA;
    }




    /*public String selectbal(String dob) {
        // TODO Auto-generated method stub

            Cursor c21 = null;
            String n2=null;
            DATA.clear();
            String[] columns = new String[] {  "SUM(receivedfrom)" };
            c21 = db.query(STUDENT_TABLE4, columns,"monthyear=?", new String[] {dob},null, null, null, null);
            while (c21.moveToNext()) {

                 n2=c21.getString(0);


                }
                System.out.print(n2);
                return n2;

    }*/
    public ArrayList<String[]> selectalldatabase(String smf) {
        // TODO Auto-generated method stub

        Cursor c1 = null;
        DATA.clear();
        String[] columns = new String[] { "id","datee", "meterial","qty", "amount","receivedfrom", "time" };
        c1 = db.query(STUDENT_TABLE4, columns,"monthyear=?", new String[] {smf},null, null, null, null);
        if (c1.moveToFirst()) {
            do {
                if (c1.getColumnCount() == 7) {
                    String[] str = new String[6];
                    str[0] = c1.getString(1);
                    str[1] = c1.getString(2);
                    str[2] = c1.getString(3);
                    str[3] = c1.getString(4);
                    str[4] = c1.getString(5);
                    str[5] = c1.getString(6);
                    DATA.add(str);
                }
            } while (c1.moveToNext());
        }

        if (c1 != null && !c1.isClosed()) {
            c1.close();
        }

        return DATA;
    }

    public String getkey5(String loca5) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getkey6(String loca6) {
        // TODO Auto-generated method stub
        return null;
    }
}
