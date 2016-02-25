package com.example.asus.fourthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Asus on 23.02.2016.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView textView5;
    TextView textView6;
    TextView textView7;
    Button buttonRes;
    EditText editText1;
    Switch themeSwitch;
    static int curentTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     Intent intent = getIntent();
        curentTheme = intent.getIntExtra("theme", 0);
        switch(curentTheme){
            case 1:
                setTheme(R.style.MyBlackTheme);
                break;
            case 2:
                setTheme(R.style.MyLightTheme);
                break;
        }
        setContentView(R.layout.activity_main);

        //проверка и выбор операции
        editText1 = (EditText) findViewById(R.id.Edit1_1);
        textView5 = (TextView) findViewById(R.id.textView_5);
        textView5.setOnClickListener(this);
        textView6 = (TextView) findViewById(R.id.textView_6);
        textView6.setOnClickListener(this);
        textView7 = (TextView) findViewById(R.id.textView_7);
        textView7.setOnClickListener(this);
        buttonRes = (Button) findViewById(R.id.button_res);
        buttonRes.setOnClickListener(this);
        themeSwitch = (Switch)findViewById(R.id.switch1);
        themeSwitch.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            //вызываем первый TextView
            case R.id.textView_5:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivityForResult(intent, 1);
                break;
            //вызываем второй TextView
            case R.id.textView_6:
                intent = new Intent(this, Main2Activity.class);
                startActivityForResult(intent, 2);
                break;
            case R.id.button_res:
                String oper = editText1.getText().toString();
                String num1Str = textView5.getText().toString();
                String num2Str = textView6.getText().toString();
                float res = 0;
            // проверка на наличие аргументов, оператора и отображение тоста
                if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
                    Toast.makeText(this, "Enter 2 number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(editText1.getText().toString())) {
                    Toast.makeText(this, "Enter operator", Toast.LENGTH_SHORT).show();
                } else {
                    float num1 = Float.parseFloat(num1Str);
                    float num2 = Float.parseFloat(num2Str);

                    switch(oper){
                        case "+":
                            res = num1 + num2;
                            break;
                        case "-":
                            res = num1 - num2;
                            break;
                        case "*":
                            res = num1 * num2;
                            break;
                        case "/":
                            res = num1 / num2;
                            break;
                    }

                     if (isOper(oper)) {
                        Toast.makeText(this, "Result", Toast.LENGTH_SHORT).show();
                    }
                     else {
                        Toast.makeText(this, "Change operator" + "Only *, /, +, -", Toast.LENGTH_SHORT).show();
                    }
                    textView7.setText(String.valueOf(res));
                }

                    default:
                break;
        }
    }

    private boolean isOper(String s) {
        if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/")){

            return true;

        } else return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            String res = data.getStringExtra("input");
            switch (requestCode) {
                case 1:
                    textView5.setText(res);
                    break;
                case 2:
                    textView6.setText(res);
                    break;
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.finish();

        if(curentTheme == 0){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("theme", 1);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("theme", 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
