package com.example.tel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    String num;

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

        num = "";

        final TextView text_money = findViewById(R.id.text_num);

        Button Num_0_Button = findViewById(R.id.num_0);
        Button Num_1_Button = findViewById(R.id.num_1);
        Button Num_2_Button = findViewById(R.id.num_2);
        Button Num_3_Button = findViewById(R.id.num_3);
        Button Num_4_Button = findViewById(R.id.num_4);
        Button Num_5_Button = findViewById(R.id.num_5);
        Button Num_6_Button = findViewById(R.id.num_6);
        Button Num_7_Button = findViewById(R.id.num_7);
        Button Num_8_Button = findViewById(R.id.num_8);
        Button Num_9_Button = findViewById(R.id.num_9);

        Num_0_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "0";
                text_money.setText(num);
            }
        });
        Num_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "1";
                text_money.setText(num);
            }
        });
        Num_2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "2";
                text_money.setText(num);
            }
        });
        Num_3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "3";
                text_money.setText(num);
            }
        });
        Num_4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "4";
                text_money.setText(num);
            }
        });
        Num_5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "5";
                text_money.setText(num);
            }
        });
        Num_6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "6";
                text_money.setText(num);
            }
        });
        Num_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "7";
                text_money.setText(num);
            }
        });
        Num_8_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "8";
                text_money.setText(num);
            }
        });
        Num_9_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + "9";
                text_money.setText(num);
            }
        });

        Button returnButton = findViewById(R.id.button_decision);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
