package com.example.tel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button incomeButton = findViewById(R.id.button_Income);
        Button spendingButton = findViewById(R.id.button_Spending);

        // ボタンのリスナー
        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("backgroundColor", 1);
                startActivity(intent);
            }
        });
        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("backgroundColor", 2);
                startActivity(intent);
            }
        });
    }
}
