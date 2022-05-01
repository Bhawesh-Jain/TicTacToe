package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_Button = findViewById(R.id.btn_start);
        start_Button.setOnClickListener(view -> {
            Intent changeActivity = new Intent(MainActivity.this, GameActivity.class);
            startActivity(changeActivity);
        });
    }
}