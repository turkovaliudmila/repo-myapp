package ru.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMulti;
    private Button buttonDiv;
    private Button buttonRes;

    private TextView calcTablo;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);

        buttonPlus  = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMulti = findViewById(R.id.button_multi);
        buttonDiv   = findViewById(R.id.button_div);
        buttonRes   = findViewById(R.id.button_res);

        calcTablo = findViewById(R.id.text);

        calculator = new Calculator();


        initButtonClickListener(button1);
        initButtonClickListener(button2);
        initButtonClickListener(button3);
        initButtonClickListener(button4);
        initButtonClickListener(button5);
        initButtonClickListener(button6);
        initButtonClickListener(button7);
        initButtonClickListener(button8);
        initButtonClickListener(button9);
        initButtonClickListener(button0);

    }

    private void initButtonClickListener(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (btn.getId()) {
                    case R.id.button1:  break;
                    case R.id.button2:  break;
                    case R.id.button3:  break;
                    case R.id.button4:  break;
                    case R.id.button5:  break;
                    case R.id.button6:  break;
                    case R.id.button7:  break;
                    case R.id.button8:  break;
                    case R.id.button9:  break;
                    case R.id.button0:  break;
                }
            }
        });

    }
}