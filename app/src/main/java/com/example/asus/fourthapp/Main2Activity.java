package com.example.asus.fourthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Asus on 24.02.2016.
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button button3;
    EditText editText2_1;
    EditText EditText2_2;

    TextView textView5;
    TextView textView6;
    Button button1;
    Button button2;
    EditText editText1;
    EditText EditText2;
    private int curTheme;
    private static final String THEME_ID = "theme";
    private static final int DARK_THEME = 1;
    private static final int LIGHT_THEME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        curTheme = intent.getIntExtra(THEME_ID, 1);
        if (curTheme == DARK_THEME){
            setTheme(R.style.MyBlackTheme);
        }else {
            setTheme(R.style.MyLightTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button3 = (Button)findViewById(R.id.button_2_2);
        button3.setOnClickListener(this);
        editText2_1 = (EditText)findViewById(R.id.Edit2_1);

//       textView5 = (TextView)findViewById(R.id.textView_5);
//       textView5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_2_2:
                Intent intent = new Intent();
                intent.putExtra("input",editText2_1.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

//              textView5 = new EditText(this, View.OnClickListener());

                break;
            default:
            break;
        }

    }
}
