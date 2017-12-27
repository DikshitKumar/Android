package com.example.dikshitkumarjain.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void currencyConvert(View view) {

        EditText amount = findViewById(R.id.amountTextField);

        double value = Double.parseDouble(amount.getText().toString()) * 64;

        Toast.makeText(MainActivity.this,"Converted Value in ₹ : " + value, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
