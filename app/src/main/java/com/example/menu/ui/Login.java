package com.example.menu.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.menu.R;
import com.example.menu.database.AccountDataBase;
import com.google.android.material.textfield.TextInputEditText;


public class Login extends AppCompatActivity {
    TextView sign_up,tv_error,tv_forget;
    TextInputEditText username,password;
    Button btn_login;
    CheckBox cb_save;
    Boolean saveLogin;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login=findViewById(R.id.login_btn_login);
        username=findViewById(R.id.login_et_username);
        password=findViewById(R.id.login_et_password);
        tv_error=findViewById(R.id.login_tv_error);
        sign_up=findViewById(R.id.login_tv_signup);
        cb_save=findViewById(R.id.login_ch_remember);
        tv_forget=findViewById(R.id.login_tv_forget);

        String Name = username.getText().toString();
        String Password=password.getText().toString();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountDataBase accountDataBase = new AccountDataBase(getBaseContext());
                // if user name and password is exist in account table , you can login to main activity
                boolean isExist = accountDataBase.checkUserExist(Name,Password);
                if(isExist){
                      Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                    intent.putExtra("username",Name);
                      startActivity(intent);
                } else {
                   tv_error.setText(R.string.login_tv_error);
                }
//                cb_save.setChecked(false);
            }
        });
        cb_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cb_save.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("username", Name);
                    loginPrefsEditor.putString("password", Password);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }
            }
        });
        // if click on checked to save your password and user name account
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            username.setText(loginPreferences.getString("username", ""));
            password.setText(loginPreferences.getString("password", ""));
            cb_save.setChecked(true);
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                    intent.putExtra("username",Name);
            startActivity(intent);
        }
        // if you don't have account , click on sign up text view to swap from login to sign up activity
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_sign_up  = new Intent(getBaseContext(),SignUp.class);
                startActivity(go_sign_up);
            }
        });
        // if you forget your password account , click on forget password text view to swap from login to forget activity
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_forget_password = new Intent(getBaseContext(),ForgetPassword.class);
                startActivity(intent_forget_password);
            }
        });
    }
}