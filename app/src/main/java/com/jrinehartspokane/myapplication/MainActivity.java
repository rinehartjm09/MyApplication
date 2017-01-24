package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //change
    }

    public void btnLoginOnClick(View v) {
        Log.i("CLICK", "Login button was clicked");
    }
}
