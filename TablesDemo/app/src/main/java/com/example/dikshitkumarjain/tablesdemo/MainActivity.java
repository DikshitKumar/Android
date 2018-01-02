package com.example.dikshitkumarjain.tablesdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView tableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tableSeekBar = findViewById(R.id.tableSeekBar);
        tableSeekBar.setMax(20);
        tableSeekBar.setProgress(10);

        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min = 1;
                int timesTable;
                if(i < min) {
                    timesTable = min;
                    tableSeekBar.setProgress(min);
                }
                else {
                    timesTable =i;
                }
                generateTables(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tableListView = findViewById(R.id.tableListView);

        generateTables(10);
    }

    public void generateTables(int timesTable) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            arrayList.add(i * timesTable);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, arrayList);

        tableListView.setAdapter(arrayAdapter);
    }
}
