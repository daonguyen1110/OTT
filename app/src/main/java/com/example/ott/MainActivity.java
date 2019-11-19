package com.example.ott;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBao;
    private Button btnBua;
    private Button btnKeo;
    private int pickUp = -1;
    private int resultRandom = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBao = findViewById(R.id.btnBao);
        btnBua = findViewById(R.id.btnBua);
        btnKeo = findViewById(R.id.btnKeo);
        btnBao.setOnClickListener(this);
        btnBua.setOnClickListener(this);
        btnKeo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBao:
                getRandom();
                pickUp = 1;
                intentActivity();
                break;
            case R.id.btnBua:
                getRandom();
                pickUp = 2;
                intentActivity();
                break;
            case R.id.btnKeo:
                getRandom();
                pickUp = 3;
                intentActivity();
                break;
        }
    }

    private int getRandom() {
        List<Integer> listRandom = new ArrayList<>();
        listRandom.add(1);
        listRandom.add(2);
        listRandom.add(3);
        Random random = new Random();
        resultRandom = listRandom.get(random.nextInt(listRandom.size()));
        return resultRandom;
    }

    private void intentActivity() {
        Intent intent = new Intent();
        intent.putExtra("PICK_UP", pickUp);
        intent.putExtra("RAN_DOM", resultRandom);
        intent.setClass(MainActivity.this, ResultActivity.class);
        startActivity(intent);
    }
}
