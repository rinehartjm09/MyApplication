package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Landing1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing1);
    }

    public void btnNextOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing2.class);
        startActivity(intent);
    }

    public void btnPrevOnClick(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnLoginOnClick(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
