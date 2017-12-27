package com.example.dikshitkumarjain.higherorlower;

import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    public void guess(View view) {
        String msg;
        EditText number = findViewById(R.id.guessEditText);
        int guessNumber = Integer.parseInt(number.getText().toString());
        if (guessNumber > randomNumber) {
            msg = "Lower!!";
        }
        else if (guessNumber < randomNumber) {
            msg = "Higher!!";
        }
        else {
            msg = "That's right!!";
        }
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }
}
