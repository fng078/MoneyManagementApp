package com.example.tel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                startActivityForResult(intent, 100);
            }
        });

        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("backgroundColor", 2);
                startActivityForResult(intent, 200);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100){
            int  inout_income_result = Integer.valueOf(data.getStringExtra("result"));
            Log.d("result", String.valueOf(inout_income_result));
        }
        else if(requestCode == 200){
            int  inout_spending_result = Integer.valueOf(data.getStringExtra("result"));
            Log.d("result", String.valueOf(inout_spending_result));
        }
        else{
            // TODO: エラー処理

        }
    }

}
