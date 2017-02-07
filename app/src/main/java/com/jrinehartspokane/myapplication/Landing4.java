package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Landing4 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing4);
    }

    public void btnNextOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing5.class);
        startActivity(intent);
    }

    public void btnPrevOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing3.class);
        startActivity(intent);
    }
}
