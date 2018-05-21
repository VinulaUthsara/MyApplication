package com.example.dell.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText userName, userEmail, userPassword, reUserPassword;
    private Button signupConfirmbutton;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        signupConfirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    // upload to database

                    String user_Email = userEmail.getText().toString().trim();
                    String user_Password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_Email,user_Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(SignUp.this, "Registration Successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, MainActivity.class));

                            }else{

                                Toast.makeText(SignUp.this, "Registration Failed",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });


    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        signupConfirmbutton = (Button)findViewById(R.id.SignupConfirmbtn);
        userLogin = (TextView) findViewById(R.id.tvbacktologin);

    }

    private Boolean validate(){
        Boolean result = false;

        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();
        //String repassword = reUserPassword.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();

        /*else if (password!=repassword){
            Toast.makeText(this,"Passwords do not match !", Toast.LENGTH_SHORT).show();*/
        }else{
            result = true;
        }
        return result;
    }
}
