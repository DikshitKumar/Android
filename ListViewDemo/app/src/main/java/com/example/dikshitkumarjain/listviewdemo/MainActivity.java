package com.example.dikshitkumarjain.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.nameListView);
        final ArrayList<String> nameArrayList = new ArrayList<String>();
        nameArrayList.add("DJ");
        nameArrayList.add("Nitin");
        nameArrayList.add("Rahul");
        nameArrayList.add("Sahil");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nameArrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("Name Tapped", nameArrayList.get(i));
                Toast.makeText(MainActivity.this, "Hello " + nameArrayList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
