package com.example.project;

import java.util.Calendar;

public class Reminder {
    private String Description;
    private String Title;
    public Calendar Date;

    public Reminder(){
        Date = Calendar.getInstance();

    }
    public String getDescription(){ return Description;}
    public void setDescription(String s){ Description = s; }
    public String getTitle(){ return Title; }
    public void setTitle(String s){ Title = s; }
    public Calendar getDate(){ return Date; }
    public void setDate(Calendar c){ Date = c; }
}
