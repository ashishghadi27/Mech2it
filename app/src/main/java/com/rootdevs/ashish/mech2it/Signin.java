package com.rootdevs.ashish.mech2it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void tohome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
