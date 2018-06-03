package com.example.tel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // MainActivityから送られるボタンリスナーを受け取る
        LinearLayout background = findViewById(R.id.backgroundColor);

        int backgroundColorFlag = getIntent().getIntExtra("backgroundColor", 0);

        //収入、支出が押されたとき背景が変わる
        if (backgroundColorFlag == 1) {
            background.setBackgroundColor(getResources().getColor(R.color.colorIncome));
        }
        else if (backgroundColorFlag == 2) {
            background.setBackgroundColor(getResources().getColor(R.color.colorSpending));
        }
        else {
            // TODO: エラー処理
        }


        Button returnButton = findViewById(R.id.button_decision);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
