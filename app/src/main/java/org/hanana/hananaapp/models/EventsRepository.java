package org.hanana.hananaapp.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.hanana.hananaapp.database.HananaDB;
import org.hanana.hananaapp.exceptions.HananaException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventsRepository extends HananaDB{

    public EventsRepository(Context context) {
        super(context);
    }

    public ArrayList<Event> getAllEvents() throws HananaException{

        String selectQuery = "SELECT * FROM " + TABLE_EVENT;

        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        // ArrayList of event objects
        ArrayList<Event> events = null;

        while(cursor.moveToNext()){
            if(events == null)
                events = new ArrayList<>();

            Event event = new Event(cursor.getInt(0),cursor.getInt(1));
            event.setTitle(cursor.getString(2));
            event.setVenue(cursor.getString(3));
            event.setDate(new Date());
            event.setTime(null);
            event.setLongitude(cursor.getFloat(6));
            event.setLatitude(cursor.getFloat(7));
            // TODO: convert string to date



            events.add(event);

        }
        if(events == null)
            throw new HananaException("No events are found.");
        return events;
    }



    public void insert(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();



//        EventTimeStamper eventTimeStamper = new EventTimeStamper();
//        DateFormat dateFormat = new SimpleDateFormat
//                (eventTimeStamper.getDateTimeStampFormat());
//        String date = dateFormat.format(event.getDate());

        String insertQuery = "INSERT INTO " + TABLE_EVENT ;
        insertQuery += " values( null, '" + event.getTitle();
        insertQuery += "', '" + event.getVenue();
        insertQuery += "', '" + event.getDate();
//        insertQuery += "', '" + date;
       // insertQuery += "', '" + event.getTime();
        insertQuery += "', '" + event.getLongitude();
        insertQuery += "', '" + event.getLatitude();
        insertQuery += "' )";

        db.execSQL(insertQuery);
        db.close();
        Log.i("HANANA", event.getTitle() + " is added!");


    }
}
