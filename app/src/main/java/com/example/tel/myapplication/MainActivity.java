package com.example.tel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int INCOME_REQUEST = 100;
    final static int SPENDING_REQUEST = 200;

    String inout_income_what;
    int inout_income_result;
    String inout_spending_what;
    int inout_spending_result;

    String moneyNumber;

    TextView moneyWallet;
    TextView moneyAccount;
    TextView moneyContent;

    Button incomeButton;
    Button spendingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("money", "aaaaaaaaaa");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moneyNumber = "0"; // 表示する文字列を初期化
        setFindById();

        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_background;
                intent_background = new Intent(MainActivity.this, SubActivity.class);
                intent_background.putExtra("backgroundColor", 1);
                startActivityForResult(intent_background, INCOME_REQUEST);
            }
        });

        spendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_background;
                intent_background = new Intent(MainActivity.this, SubActivity.class);
                intent_background.putExtra("backgroundColor", 2);
                startActivityForResult(intent_background, SPENDING_REQUEST);
            }
        });
    }


    /**
     * SubActivityから金額を受け取る
     *
     * @param requestCode = INCOME_REQUEST　or  SPENDING_REQUEST
     * @param resultCode
     * @param data        = SubActivity から来たデータを受け取る
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INCOME_REQUEST) {
            inout_income_what = data.getStringExtra("what");
            inout_income_result = Integer.valueOf(data.getStringExtra("result"));
            moneyNumber = String.valueOf(Integer.parseInt(moneyNumber) + inout_income_result);

            Log.d("what", String.valueOf(inout_income_what));
            Log.d("result", String.valueOf(inout_income_result));
        } else if (requestCode == SPENDING_REQUEST) {
            inout_spending_what = data.getStringExtra("what");
            inout_spending_result = Integer.valueOf(data.getStringExtra("result"));
            moneyNumber = String.valueOf(Integer.parseInt(moneyNumber) - inout_spending_result);


            Log.d("what", String.valueOf(inout_spending_what));
            Log.d("result", String.valueOf(inout_spending_result));
        } else {
            // TODO: エラー処理
        }


        moneyWallet.setText(moneyNumber);
    }

    /**
     * LayoutのId取得
     */
    private void setFindById() {
        incomeButton = findViewById(R.id.button_Income);
        spendingButton = findViewById(R.id.button_Spending);

        moneyWallet = findViewById(R.id.money_wallet);
        moneyAccount = findViewById(R.id.money_account);
        moneyContent = findViewById(R.id.money_content);

    }
}
