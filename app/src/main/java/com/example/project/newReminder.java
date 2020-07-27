package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class newReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

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
    }
}