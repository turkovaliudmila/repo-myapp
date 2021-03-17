package ru.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFRENCES = "LOGIN";
    private static final String APP_THEME_DEFAULT = "MyStyle";

    private static final int APP_THEME_LIGHT = 0;
    private static final int APP_THEME_DARK = 1;

    private static final String CURRENT_THEME = "CURRENT_THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyStyle));
        setContentView(R.layout.activity_settings);

        Button btnReturn = findViewById(R.id.ReturnButton);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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