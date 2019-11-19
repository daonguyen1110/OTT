package com.example.ott;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    private Button btnBot;
    private Button btnUser;
    private TextView tvResult;
    private int pickUp;
    private int resultRandom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        btnBot = findViewById(R.id.btnBotResult);
        btnUser = findViewById(R.id.btnUserResult);
        tvResult = findViewById(R.id.tvResult);
        Intent intent = getIntent();
        pickUp = intent.getIntExtra("PICK_UP", -1);
        resultRandom = intent.getIntExtra("RAN_DOM", -1);
        if (pickUp == 1) {
            btnUser.setText("USER: Bao");
        } else if (pickUp == 2) {
            btnUser.setText("USER: BUA");
        } else if (pickUp == 3) {
            btnUser.setText("USER: KEO");
        }
        if (resultRandom == 1) {
            btnBot.setText("BOT: Bao");
        } else if (resultRandom == 2) {
            btnBot.setText("BOT: BUA");
        } else if (resultRandom == 3) {
            btnBot.setText("BOT: KEO");
        }
        if (pickUp == 1 && resultRandom == 2) {
            tvResult.setText("Ban Thang");
        } else if (pickUp == 1 && resultRandom == 3) {
            tvResult.setText("Ban Thua");
        } else if (pickUp == 2 && resultRandom == 3) {
            tvResult.setText("Ban Thang");
        } else if (pickUp == 2 && resultRandom == 1) {
            tvResult.setText("Ban Thua");
        } else if (pickUp == 3 && resultRandom == 1) {
            tvResult.setText("Ban Thang");
        } else if (pickUp == 3 && resultRandom == 2) {
            tvResult.setText("Ban Thua");
        }else if (pickUp ==  resultRandom ) {
            tvResult.setText("Ban Hoa");
        }
    }
}
