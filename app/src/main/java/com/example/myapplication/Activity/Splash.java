package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();

            }


        },2000);
    }
    private void nextActivity() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            //chua login
            Intent intent= new Intent(this, Login.class);
            startActivity(intent);
        }
        else {
            //da login
            Intent intent= new Intent(this, Home.class);
            startActivity(intent);

        }
    }
}