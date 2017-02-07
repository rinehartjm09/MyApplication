package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Landing5 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing5);
    }

    public void btnNextOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing5.class);
        startActivity(intent);
    }

    public void btnPrevOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing4.class);
        startActivity(intent);
    }
}