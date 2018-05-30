package org.hanana.hananaapp.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HananaDB extends SQLiteOpenHelper {
    // private static fields for Database version and name
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HananaDB";

    // user schema
    protected static final String TABLE_USER = "user";
    protected static final String U_ID = "id";
    protected static final String U_USER_NAME = "username";
    protected static final String U_NAME = "name";
    protected static final String U_PASSWORD = "password";
    protected static final String U_EMAIL = "email";
    protected static final String U_PHONE_NUMBER = "phonenumber";

    //event schema
    protected static final String TABLE_EVENT = "event";
    protected static final String E_ID = "id";
    protected static final String E_UID = "uid";
    protected static final String E_EVENT_TITLE = "eventname";
    protected static final String E_VENUE = "venue";
    protected static final String E_DATE = "date";
    protected static final String E_TIME = "time";
    protected static final String E_LONGITUDE = "longitude";
    protected static final String E_LATITUDE = "latitude";


    public HananaDB(Context context){
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Forming the create user table query
        String createUserTable = "create table " + TABLE_USER + "( " + U_ID;
        createUserTable += " integer primary key autoincrement, " + U_USER_NAME;
        createUserTable += " text, " + U_PASSWORD + " text, " + U_NAME + " text, ";
        createUserTable += U_EMAIL + " text, " + U_PHONE_NUMBER + " text )";

        // creating the tables
        sqLiteDatabase.execSQL(createUserTable);

        // Forming the create event table query
        String createEventTable = "create table " + TABLE_EVENT + "( " + E_ID;
        createEventTable += " integer primary key autoincrement, " + E_UID + " integer, " + E_EVENT_TITLE;
        createEventTable += " text, " + E_VENUE + " text, " + E_DATE + " text, ";
        createEventTable += E_TIME + " text, " + E_LATITUDE + " text," + E_LONGITUDE + "text )";

        // creating the tables
        sqLiteDatabase.execSQL(createEventTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // dropping the tables
        db.execSQL("drop table if exists " + TABLE_USER);
        db.execSQL("drop table if exists " + TABLE_EVENT);
        // re-creating the tables
        onCreate(db);
    }


}
