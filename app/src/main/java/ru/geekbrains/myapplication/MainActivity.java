package ru.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFRENCES = "LOGIN";
    private static final String APP_THEME_DEFAULT = "MyStyle";

    private static final int APP_THEME_LIGHT = 0;
    private static final int APP_THEME_DARK = 1;

    private static final String CURRENT_THEME = "CURRENT_THEME";

    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    private int curAppTheme;

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
    private Button buttonDot;

    private TextView calcTablo;

    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyStyle));
        setContentView(R.layout.calculator_layout);

        curAppTheme = 0;

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
        buttonDot   = findViewById(R.id.button_dot);

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

        initButtonClickListener(buttonPlus);
        initButtonClickListener(buttonMinus);
        initButtonClickListener(buttonMulti);
        initButtonClickListener(buttonDiv);

        initButtonClickListener(buttonRes);

        initButtonClickListener(buttonDot);

        initButtonSettings();

    }

    private void initButtonClickListener(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (btn.getId()) {
                    case R.id.button1:
                        calculator.inputNumber(calcTablo.getText().toString(), 1);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button2:
                        calculator.inputNumber(calcTablo.getText().toString(), 2);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button3:
                        calculator.inputNumber(calcTablo.getText().toString(), 3);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button4:
                        calculator.inputNumber(calcTablo.getText().toString(), 4);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button5:
                        calculator.inputNumber(calcTablo.getText().toString(), 5);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button6:
                        calculator.inputNumber(calcTablo.getText().toString(), 6);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button7:
                        calculator.inputNumber(calcTablo.getText().toString(), 7);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button8:
                        calculator.inputNumber(calcTablo.getText().toString(), 8);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button9:
                        calculator.inputNumber(calcTablo.getText().toString(), 9);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button0:
                        calculator.inputNumber(calcTablo.getText().toString(), 0);
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_plus:
                        calculator.inputOperation(calcTablo.getText().toString(), "+");
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_minus:
                        calculator.inputOperation(calcTablo.getText().toString(), "-");
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_div:
                        calculator.inputOperation(calcTablo.getText().toString(), "/");
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_multi:
                        calculator.inputOperation(calcTablo.getText().toString(), "*");
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_res:
                        double resNumber = calculator.getRes();
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                    case R.id.button_dot:
                        calculator.inputDot(calcTablo.getText().toString());
                        calcTablo.setText(calculator.getTextTablo());
                        break;
                }
            }
        });

    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NAME_SHARED_PREFRENCES, MODE_PRIVATE);
        return sharedPreferences.getInt(APP_THEME_DEFAULT, codeStyle);
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case APP_THEME_LIGHT:
                return R.style.AppThemeLight;
            case APP_THEME_DARK:
                return R.style.AppThemeDark;
            default:
                return R.style.MyStyle;
        }
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NAME_SHARED_PREFRENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(APP_THEME_DEFAULT, codeStyle);
        editor.apply();
    }

    private void initButtonSettings() {
        Button btnSettings = findViewById(R.id.SettingsButton);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                runSettings.putExtra(CURRENT_THEME, curAppTheme);
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK) {
            curAppTheme = data.getExtras().getInt(CURRENT_THEME);
            setAppTheme(curAppTheme);
            recreate();
        }
    }
}