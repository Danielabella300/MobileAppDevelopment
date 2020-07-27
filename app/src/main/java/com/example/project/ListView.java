package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    RecyclerView reminderList;
    reminderAdapter reminderAdapter;
    ArrayList<Reminder> reminders;

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            int reminderId = reminders.get(position).getReminderID();
            Intent intent = new Intent(ListView.this, MainActivity.class);
            intent.putExtra("reminderID", reminderId);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        Button loadCreateNewReminder = (Button) findViewById(R.id.createNewButton);
        loadCreateNewReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),newReminder.class));
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

    @Override
    public void onResume(){
        super.onResume();

        String sortBy = getSharedPreferences("ReminderPreferences", Context.MODE_PRIVATE).getString("sortfield", "reminder");

    }
}