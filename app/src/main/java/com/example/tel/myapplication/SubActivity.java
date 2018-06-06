package com.example.tel.myapplication;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    String displayNumber;

    TextView text_money;

    RadioGroup radioGroup;
    RadioButton wallet_Button;
    RadioButton account_Button;
    RadioButton credit_Button;

    Button Num_0_Button;
    Button Num_1_Button;
    Button Num_2_Button;
    Button Num_3_Button;
    Button Num_4_Button;
    Button Num_5_Button;
    Button Num_6_Button;
    Button Num_7_Button;
    Button Num_8_Button;
    Button Num_9_Button;

    LinearLayout background;

    Button returnButton;

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        displayNumber = ""; // 表示する文字列を初期化
        setFindById();

        // 関数宣言
        setNumberCalculatorListener();
        setChangeBackgroundColor();
        setRadioButtonBehavior();
        setReturnButtonBehavior();

        // TODO: SharedPreferencesによる処理追加
//        money_data = getSharedPreferences("money_data", MODE_PRIVATE);
//        SharedPreferences.Editor money_data_editor = money_data.edit();
//        money_data_editor.putString("input", displayNumber);
//        money_data_editor.apply();
    }

    /**
     * 収入の時は背景を青色に変化させる
     * 支出の時は背景を赤色に変化させる
     */
    private void setChangeBackgroundColor() {
        // MainActivityから送られるボタンリスナーを受け取る
        int backgroundColorFlag = getIntent().getIntExtra("backgroundColor", 0);
        if (backgroundColorFlag == 1) {
            background.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncome));
        } else if (backgroundColorFlag == 2) {
            background.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSpending));
        } else {
            // TODO: エラー処理
        }
    }

    /**
     * クリックイベント関数（数字用）
     */
    private void setNumberCalculatorListener() {
        Num_0_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "0";
                text_money.setText(displayNumber);
            }
        });
        Num_1_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "1";
                text_money.setText(displayNumber);
            }
        });
        Num_2_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "2";
                text_money.setText(displayNumber);
            }
        });
        Num_3_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "3";
                text_money.setText(displayNumber);
            }
        });
        Num_4_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "4";
                text_money.setText(displayNumber);
            }
        });
        Num_5_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "5";
                text_money.setText(displayNumber);
            }
        });
        Num_6_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "6";
                text_money.setText(displayNumber);
            }
        });
        Num_7_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "7";
                text_money.setText(displayNumber);
            }
        });
        Num_8_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "8";
                text_money.setText(displayNumber);
            }
        });
        Num_9_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber = displayNumber + "9";
                text_money.setText(displayNumber);
            }
        });
    }

    /**
     * LayoutのId取得
     */
    private void setFindById() {
        radioGroup = findViewById(R.id.radio_group);
        wallet_Button = findViewById(R.id.RadioButton_wallet);
        account_Button = findViewById(R.id.RadioButton_account);
        credit_Button = findViewById(R.id.RadioButton_credit);

        text_money = findViewById(R.id.text_num);

        Num_0_Button = findViewById(R.id.num_0);
        Num_1_Button = findViewById(R.id.num_1);
        Num_2_Button = findViewById(R.id.num_2);
        Num_3_Button = findViewById(R.id.num_3);
        Num_4_Button = findViewById(R.id.num_4);
        Num_5_Button = findViewById(R.id.num_5);
        Num_6_Button = findViewById(R.id.num_6);
        Num_7_Button = findViewById(R.id.num_7);
        Num_8_Button = findViewById(R.id.num_8);
        Num_9_Button = findViewById(R.id.num_9);

        background = findViewById(R.id.backgroundColor);

        returnButton = findViewById(R.id.button_decision);

    }

    /**
     * ラジオボタン系のロジックを記述
     * TODO: 何をしてるかを記述
     */
    private void setRadioButtonBehavior() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int id) {
                if (id == -1) {
                    // TODO:何も押されていないときの処理
                    Toast.makeText(SubActivity.this,
                            "クリアされました",
                            Toast.LENGTH_SHORT).show();
                } else if (findViewById(id) == wallet_Button) {
                    intent.putExtra("what", wallet_Button.getText().toString());
                } else if (findViewById(id) == account_Button) {
                    intent.putExtra("what", account_Button.getText().toString());
                } else if (findViewById(id) == credit_Button) {
                    intent.putExtra("what", credit_Button.getText().toString());
                } else {
                    //TODO: エラー処理
                }
            }
        });
    }

    /**
     * 戻るボタンを押した時のロジックを記述
     * 表示されているテキストをMainActivity.javaに返す
     * 画面遷移する
     */
    private void setReturnButtonBehavior() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String str = money_data.getString("input", "0");
//                if(!str.equals("0")) {
//                    text_money.setText(str);
//                }
                intent.putExtra("result", text_money.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
