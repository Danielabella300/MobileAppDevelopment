package com.example.project;

import java.util.Calendar;

public class Reminder{
    private int reminderID;
    private String Description;
    private String Title;
    public Calendar Date;

    public Reminder(){
        reminderID = -1;
        Date = Calendar.getInstance();

    }
    public int getReminderID() {
        return reminderID;
    }
    public void setReminderID(int i) {
        reminderID = i;
    }
    public String getDescription(){ return Description;}
    public void setDescription(String s){ Description = s; }
    public String getTitle(){ return Title; }
    public void setTitle(String s){ Title = s; }
    public Calendar getDate(){ return Date; }
    public void setDate(Calendar c){ Date = c; }
}
