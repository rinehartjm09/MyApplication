package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Landing2 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing2);
    }

    public void btnNextOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing3.class);
        startActivity(intent);
    }

    public void btnPrevOnClick(View v) {
        finish();
        Intent intent = new Intent(this, Landing1.class);
        startActivity(intent);
    }
}
