package ru.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFRENCES = "LOGIN";
    private static final String APP_THEME_DEFAULT = "MyStyle";

    private static final int APP_THEME_LIGHT = 0;
    private static final int APP_THEME_DARK = 1;

    private static final String CURRENT_THEME = "CURRENT_THEME";

    private int curAppTheme;

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyStyle));
        curAppTheme = getIntent().getExtras().getInt(CURRENT_THEME);
        setAppTheme(curAppTheme);
        setContentView(R.layout.activity_settings);

        radioGroup = (RadioGroup)findViewById(R.id.RadioButtons);

        Button btnReturn = findViewById(R.id.ReturnButton);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent();
                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId) {
                    case R.id.RadioButtonMaterialLight: {
                        curAppTheme = APP_THEME_LIGHT;
                        break;
                    }
                    case R.id.RadioButtonMaterialDark: {
                        curAppTheme = APP_THEME_DARK;
                        break;
                    }
                }
                intentResult.putExtra(CURRENT_THEME, curAppTheme);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });

        initThemeChooser();
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.RadioButtonMaterialLight), APP_THEME_LIGHT);
        initRadioButton(findViewById(R.id.RadioButtonMaterialDark), APP_THEME_DARK);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
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
}