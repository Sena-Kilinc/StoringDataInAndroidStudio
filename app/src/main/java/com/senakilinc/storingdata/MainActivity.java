package com.senakilinc.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText textNum;
    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNum = findViewById(R.id.textNum);
        textView= findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.senakilinc.storingdata",Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge",0);
        if(storedAge ==0){
            textView.setText("Your age: ");
        }else {
            textView.setText("Your age: "+storedAge);

        }

    }



    public void save(View view){
        int age =Integer.parseInt(textNum.getText().toString());
        if (!textNum.getText().toString().matches("")){
            textView.setText("Your age: " + age);
            sharedPreferences.edit().putInt("storedAge",age).apply();
        }else{
            textView.setText("Invalid input");
        }
    }
    public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);
        if(storedData !=0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age: ");
        }
    }
}