package com.example.whatsappclone.LogInSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.whatsappclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LogInActivity extends AppCompatActivity {

    TextView needanewAccount,forgotpassword;
    Button phonenumberlogIn,LogIn;
    EditText email,password;
    DatabaseReference UserRef;
    FirebaseAuth auth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Intialize();
        needanewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sendusertoregactivity();
            }
        });
        phonenumberlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sendusertophoneactivity();
            }
        });
    }

    private void Sendusertoregactivity() {
        Intent intent = new Intent(LogInActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
    private void Sendusertophoneactivity() {

        Intent intent =new Intent(LogInActivity.this, PhnoLogInActivity.class);
        startActivity(intent);

    }

    private void Intialize() {
        needanewAccount=findViewById(R.id.needanewAccount);
        phonenumberlogIn=findViewById(R.id.phone_number_login);
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);
        LogIn=findViewById(R.id.login_btn);
        forgotpassword=findViewById(R.id.forgot_password);
        auth=FirebaseAuth.getInstance();
    }
}