package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnAddNewAlarm;
    private RecyclerView recyclerView;

    private static ArrayList<Alarm> allAlarms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Calendar calendar = Calendar.getInstance();
//        Log.d(TAG, "onCreate: Year: " + calendar.get(Calendar.YEAR));

        if(null == allAlarms) {
            allAlarms = new ArrayList<>();
        }

        btnAddNewAlarm = (Button) findViewById(R.id.btnAddNewAlarm);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        btnAddNewAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewAlarmActivity.class);
                startActivity(intent);
            }
        });

        try{
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));

            if(null != bundle) {
                int hours = bundle.getInt(getString(R.string.hours), -1);
                int minutes = bundle.getInt(getString(R.string.minutes), -1);

                if(hours != -1) {
                    if(minutes != -1) {
                        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hours);
                        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Hello from the other side");

                        Alarm alarm = new Alarm(hours, minutes, "Hello from the other side");
                        allAlarms.add(alarm);

                        startActivity(alarmIntent);
                    }
                }
            } else {
                Log.d(TAG, "onCreate: bundle is null");
            }

        } catch (Exception e) {
            Log.d(TAG, "onCreate: something happened");
            e.printStackTrace();
        }

    }
}