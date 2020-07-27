package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class newReminder extends AppCompatActivity {
    private Reminder currentReminder;
    EditText mHourEditText;
    EditText mMinuteEditText;
    EditText mTitleEditText;
    EditText mDescriptionEditText;
    private CalendarView mCalendarView;

    Button mSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        Reminder person = new Reminder();
        person.setTitle("Homework");
        person.setDescription("Project due soon");

        Button loadListOfAlarm = (Button) findViewById(R.id.listReminderButton);
        loadListOfAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ListView.class));
            }
        });

        Button loadSettings = (Button) findViewById(R.id.settingsButton);
        loadSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Settings.class));
            }
        });
        Button loadCalendar = (Button) findViewById(R.id.calendarButton);
        loadCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),calendarScreen.class));
            }
        });

        mHourEditText = (EditText) findViewById(R.id.editHour);
        mMinuteEditText = (EditText) findViewById(R.id.editMinute);
        mTitleEditText = (EditText) findViewById(R.id.editTitle);
        mDescriptionEditText = (EditText) findViewById(R.id.editDescription);

        mSubmit = (Button) findViewById(R.id.submitButton);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCalendarView = Calendar.getInstance();
                String title = mDescriptionEditText.getText().toString();
                int hour = Integer.parseInt(mHourEditText.getText().toString());
                int minute = Integer.parseInt(mMinuteEditText.getText().toString());

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR,hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,title);


                if(hour <= 24 && minute <= 60) {
                    startActivity(intent);
                }
            }
        });
    }
}