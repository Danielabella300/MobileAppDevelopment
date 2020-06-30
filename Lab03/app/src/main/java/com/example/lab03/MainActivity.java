package com.example.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private static final String database_url = "jdbc:mysql://studentcoded.com:3306/4360_db";
    private static final String database_user = "csc4360dbviewer";
    private static final String database_pass = "p;fw3X2K!ab,Q";
    //placeholder
    private static TextView getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find the screen element
        getData = (TextView) findViewById(R.id.queryResults1);
        Button loadDataButton = (Button) findViewById(R.id.getDataButton1);
        //set the onClick listener for the button
        loadDataButton.setOnClickListener(new View.OnClickListener()
                                          {
                                              @Override
                                              public void onClick(View v){
                                                  new getDataFromDatabase().execute();
                                              }
                                          }
                                          );
    }

    public static class getDataFromDatabase extends AsyncTask<Void, Void, Void> {
        private String queryResult;
        protected Void doInBackground(Void... arg0){
            try {
                queryResult = "Database Connection Success\n";

                Class.forName(".com.mysqwl.jdbc.Driver");
                Connection con = DriverManager.getConnection(database_url, database_user, database_pass);
                String queryString = "select * from csc4360_db.film limit 5";

                Statement st = con.createStatement();
                final ResultSet rs = st.executeQuery(queryString);
                ResultSetMetaData rsmd = rs.getMetaData();

                //do some things with the data
                while (rs.next()) {
                    queryResult += rsmd.getColumnName(1) + ": " + rs.getString(1) + "\n";
                    queryResult += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
                }

                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                //Put the error into the textview
                queryResult = "Database connection failure\n" + e.toString();
            }

            return null;
        }

        protected void onPostExecute(Void result){
            getData.setText(queryResult);
        }
    }
}