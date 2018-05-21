package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {


    private Button RegistrationConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        RegistrationConfirm = (Button)findViewById(R.id.Regconfirmbtn);



        RegistrationConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Regconfirmbtn();
            }
        });


    }

    private void Regconfirmbtn(){
        Intent intent = new Intent(Registration.this, ChooseDisorder.class);
        startActivity(intent);

    }
}
