package com.example.weremindyou;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;
public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String DATABASE_NAME = "Alarm1";
    private static final String TABLE_NAME = "Alarms1";


    String CREATE_TABLE = "Create Table IF NOT EXISTS " + TABLE_NAME + " ( " +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " alaram_id INTEGER," +
            " title TEXT," +
            " enabled INTEGER," +
            " priority TEXT," +
            " hour INTEGER," +
            " minute INTEGER," +
            " date INTEGER," +
            " month String ," +
            " day TEXT," +
            " location TEXT)";
    public DBHelper(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }



    public void insertStudent(String s)
    {
        db = this.getWritableDatabase();
        db.execSQL(s);
    }

    public void toggle_enable(int id,int enable_status)
    {
        db = this.getWritableDatabase();
        enable_status = 1 - enable_status;
        String query = "UPDATE "+TABLE_NAME +" SET enabled = "+enable_status+" WHERE alaram_id = "+id;
        db.execSQL(query);
    }

    public void updateAlarm(Alarm alarm){
        db =this.getWritableDatabase();
        String q = "UPDATE "+ TABLE_NAME+" SET title='"+alarm.getTitle()+ "', enabled = '"+alarm.isEnabled()+"', priority = '"+alarm.getPriority()+"' , hour='"+alarm.getHour()+ "', minute = '"+alarm.getMinute()+"', date = '"+alarm.getDate()+"' , month='"+alarm.getMonth()+ "', day = '"+alarm.getDay()+"', location = '"+alarm.getLocation()+ "' WHERE _id="+alarm.getId();


        Log.d("update",q);
        db.execSQL(q);
        Log.d("all data","started");
        getAllData();
        db.close();
    }
    public List<Alarm> getAlarmbyID(int id)
    {

        List<Alarm> list =new  ArrayList< >() ;
        db =this.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE _id = "+id;
        Cursor result = db.rawQuery(query,null);
        if (result.moveToFirst()){
            for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext())
            {
                int _id = result.getInt(0);
                int alarm_id = result.getInt(1);
                String title = result.getString(2);
                int enabled=result.getInt(3);
                String priority = result.getString(4);
                int hour = result.getInt(5);
                int minute = result.getInt(6);
                int date = result.getInt(7);
                String month = result.getString(8);
                String day = result.getString(9);
                String location = result.getString(10);
                Alarm alarm = new Alarm(_id, alarm_id,title,enabled,priority,hour,minute,date,month,day,location);
                list.add(alarm);
            }
        }
        db.close();
        return list;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Alarm","Alarm table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}