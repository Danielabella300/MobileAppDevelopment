package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initSettings();
        initSortByClick();

        Button loadCreateNewReminder = (Button) findViewById(R.id.createNewButton);
        loadCreateNewReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),newReminder.class));
            }
        });

        Button loadListOfAlarm = (Button) findViewById(R.id.listReminderButton);
        loadListOfAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ListView.class));
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

    private void initSettings() {
        String sortBy = getSharedPreferences("ProjectPreferences",
                Context.MODE_PRIVATE).getString("sortfield", "contactname");

        RadioButton rbTitle = findViewById(R.id.titleButton);
        RadioButton rbDate = findViewById(R.id.dateButton);
        if (sortBy.equalsIgnoreCase("title")) {
            rbTitle.setChecked(true);
        } else {
            rbDate.setChecked(true);
        }
    }

    private void initSortByClick() {
        RadioGroup rgSortBy = findViewById(R.id.sortGroup);
        rgSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbTitle = findViewById(R.id.titleButton);
                RadioButton rbDate = findViewById(R.id.dateButton);
                if (rbTitle.isChecked()) {
                    getSharedPreferences("ProjectPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortfield", "title").apply();
                } else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortfield", "date").apply();
                }
            }
        });
    }
}