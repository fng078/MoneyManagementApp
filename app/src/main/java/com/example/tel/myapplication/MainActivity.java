package com.example.tel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final static int INCOME_REQUEST = 100;
    final static int SPENDING_REQUEST = 200;

    Button incomeButton;
    Button spendingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFindById();

        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("backgroundColor", 1);
                startActivityForResult(intent, INCOME_REQUEST);
            }
        });

        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("backgroundColor", 2);
                startActivityForResult(intent, SPENDING_REQUEST);
            }
        });
    }

    /**
     * SubActivityから金額を受け取る
     * @param requestCode = INCOME_REQUEST　or  SPENDING_REQUEST
     * @param resultCode
     * @param data = SubActivity から来たデータを受け取る
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INCOME_REQUEST) {
            int inout_income_result = Integer.valueOf(data.getStringExtra("result"));
            Log.d("result", String.valueOf(inout_income_result));
        } else if (requestCode == SPENDING_REQUEST) {
            int inout_spending_result = Integer.valueOf(data.getStringExtra("result"));
            Log.d("result", String.valueOf(inout_spending_result));
        } else {
            // TODO: エラー処理
        }
    }

    /**
     * LayoutのId取得
     */
    private void setFindById() {
        incomeButton = findViewById(R.id.button_Income);
        spendingButton = findViewById(R.id.button_Spending);
    }
}