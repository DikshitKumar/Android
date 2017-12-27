package com.example.dikshitkumarjain.buttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void okFunction(View view) {
        Log.i("Info", "Ok Button Pressed!!");
    }

    public void cancelFunction(View view) {
        Log.i("Info","Cancel Button Pressed!!");
    }

    public void login(View view) {

        EditText nameTextField = findViewById(R.id.nameText);
        EditText passwordTextField = findViewById(R.id.passwordText);

        Log.i("Info", "UserName: " + nameTextField.getText().toString() + " Password: " + passwordTextField.getText().toString());

    }

    public void showPassword(View view) {
        EditText passwordTextField = findViewById(R.id.passwordText);
        Toast.makeText(MainActivity.this, "Entered Password is :" + passwordTextField.getText().toString(), Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_btn);
        setContentView(R.layout.activity_main_login);
    }
}
