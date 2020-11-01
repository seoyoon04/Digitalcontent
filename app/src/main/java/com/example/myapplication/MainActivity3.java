package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    Button moveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveButton = findViewById(R.id.moveButton);
        moveButton.setOnClickListener(onClickListener);

        SharedPreferences pref = getSharedPreferences("checkFirst", Activity.MODE_PRIVATE);
        boolean checkFirst = pref.getBoolean("checkFirst", false);
        if (checkFirst == false) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("checkFirst", false);
            editor.commit();

            Intent intent = new Intent(MainActivity3.this, IntroActivity.class);
            startActivity(intent);
            finish();
        } else {

        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.moveButton:
                    Intent intent = new Intent(MainActivity3.this, IntroActivity.class);
                    startActivity(intent);
                    finish();
            }
        }
    };


}