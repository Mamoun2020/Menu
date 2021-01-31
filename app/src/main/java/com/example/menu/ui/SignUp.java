package com.example.menu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.menu.R;
import com.example.menu.database.Account;
import com.example.menu.database.AccountDataBase;
import com.google.android.material.textfield.TextInputEditText;


public class SignUp extends AppCompatActivity {
    TextView login;
    TextInputEditText user_name,phone,password,address;
    Button btn_Sign_up;
    AccountDataBase db;
    TextView tv_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        login=findViewById(R.id.signup_tv_Login);
        user_name=findViewById(R.id.signup_et_username);
        phone=findViewById(R.id.singup_et_phone);
        password=findViewById(R.id.signup_et_password);
        address=findViewById(R.id.signup_et_city);
        btn_Sign_up=findViewById(R.id.Signup_btn_Signup);
        tv_result=findViewById(R.id.signup_tv_result);

        db = new AccountDataBase(this);
        btn_Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= user_name.getText().toString();
                String Phone= phone.getText().toString();
                String Password= password.getText().toString();
                String Address= address.getText().toString();
                // take data from field to create account in DB
                if (!Name.equals(getString(R.string.signup_et_username)) && !Password.equals(getString(R.string.signup_et_password))) {
                    //add these data to account object to send it into DB , to account table
                    Account account = new Account(Name, Phone, Password, Address);
                    if (account != null) {
                        // insert account object
                        boolean res = db.insertAccount(account);
                        if (res) {
                            // if res return true ,that is means success add new account
                            tv_result.setText(R.string.signup_tv_result1);
                        } else {
                            tv_result.setText(R.string.signup_tv_result3);
                        }
                    }
                }else {
                    tv_result.setText(R.string.signup_tv_result2);
                }
            }
        });
        //if you have account, click on text view login to swap from sign up to login activity
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_login  = new Intent(getBaseContext(),Login.class);
                startActivity(go_login);
            }
        });
    }
}