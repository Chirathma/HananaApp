package org.hanana.hananaapp.events;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.hanana.hananaapp.DatePickerFragment;
import org.hanana.hananaapp.R;
import org.hanana.hananaapp.TimePickerFragment;
import org.hanana.hananaapp.models.Event;
import org.hanana.hananaapp.models.EventTimeStamper;
import org.hanana.hananaapp.models.EventsRepository;
import org.hanana.hananaapp.models.TimeStamper;
import org.hanana.hananaapp.models.ViewUpdater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventActivity extends AppCompatActivity implements ViewUpdater{
    private EditText mEventTitle_EditText;
    private EditText mEventVenue_EditText;
    private Button mEventDate_Button;
    private Button mEventTime_Button;
    private EditText mLongitude_EditText;
    private EditText mLatitude_EditText;

    private TextView mEventTitle_TextView;
    private TextView mEventVenue_TextView;
    private TextView mEventDate_TextView;
    private TextView mEventTime_TextView;
    private TextView mLongitude_TextView;
    private TextView mLatitude_TextView;

    private Button mEventAddButton;

    private TimeStamper mTimeStamper;
    private ViewUpdater mViewUpdater;

    private EventsRepository mEventsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mTimeStamper = new EventTimeStamper();
        mViewUpdater = this;
        mEventsRepository = new EventsRepository(this);
        setupWidgets();
        setupListeners();
    }

    private void setupWidgets() {
        mEventTitle_EditText = (EditText) findViewById(R.id.event_title_edit_text);
        mEventVenue_EditText = (EditText) findViewById(R.id.event_venue_edit_text);
        mEventDate_Button = findViewById(R.id.select_date_button);
        mEventTime_Button = findViewById(R.id.select_time_button);

    }

    private void setupListeners(){
        mEventAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.i("HANANA APP", mTimeStamper.getDateTimeStamp());

                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat(mTimeStamper.getDateTimeStampFormat());

                try{
                    Date date = simpleDateFormat.parse(mTimeStamper.getDateTimeStamp());
                    Log.i("HANANA APP", date.toString());

                    Event event = new Event();
//                    event.set
                    event.setTitle(mEventTitle_EditText.getText().toString());
                    event.setVenue(mEventVenue_EditText.getText().toString());
                    event.setDate(date);
                    event.setTime(mEventTime_Button.getText().toString());
                    event.setLatitude(Float.parseFloat(mLatitude_EditText.getText().toString()));
                    event.setLongitude(Float.parseFloat(mLongitude_EditText.getText().toString()));

                    mEventsRepository.insert(event);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        // selecting time
        mEventTime_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setTimeStamper(mTimeStamper);
                timePickerFragment.setViewUpdater(mViewUpdater);
//                timePickerFragment.show(getSupportFragmentManager(), "timePicker");
            }
        });

        // selecting date
        mEventDate_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.setTimeStamper(mTimeStamper);
                datePickerFragment.setViewUpdater(mViewUpdater);
                datePickerFragment.show(getSupportFragmentManager(), "datepicker");
            }
        });
    }

    @Override
    public void updateView() {

    }
}
