package com.example.menu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.menu.R;
import com.example.menu.database.AccountDataBase;
import com.google.android.material.textfield.TextInputEditText;

public class ForgetPassword extends AppCompatActivity {
    Button btn_ok;
    TextInputEditText Name,reset_pass,confirm_pass;
    TextView tv_error;
    // to reset new password in BD when click on forget in login activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btn_ok=findViewById(R.id.forget_btn_ok);
        Name=findViewById(R.id.forget_et_username);
        reset_pass=findViewById(R.id.forget_et_password);
        confirm_pass=findViewById(R.id.forget_et_conpassword);
        tv_error=findViewById(R.id.forget_tv_error);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get user name to check if exist or not
                String name = Name.getText().toString();
                //get new information such as password to update it by username
                String reset_password = reset_pass.getText().toString();
                String confirm = confirm_pass.getText().toString();
                AccountDataBase accountDataBase = new AccountDataBase(getBaseContext());
                // if return true , the user name exist on account table
                boolean checkuser = accountDataBase.searchonUser(name);
                if (checkuser) {
                    if (name.equals(confirm)) {
                        // up to date new password in account table
                        boolean reset = accountDataBase.updateAccount(name, reset_password);
                        if (reset) {
                            // if update has been successfully ,print in text view message
                            tv_error.setText(R.string.forget_tv_msg);
                            Intent go_login = new Intent(getBaseContext(), Login.class);
                            startActivity(go_login);
                            
                        }
                    } else {
                        //if there are any problem like as the first password field different with the second field , print password does't match
                        tv_error.setText(R.string.forget_tv_error1);
                    }
                }
                else{
                    // if the check user variable return false ,that is means the user doesn't have account in DB
                  tv_error.setText(R.string.forget_tv_error2);
                }
            }
        });
    }
}