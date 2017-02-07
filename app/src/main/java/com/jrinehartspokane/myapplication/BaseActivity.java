package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by joerinehart on 2/7/17.
 */

public class BaseActivity extends AppCompatActivity {
    public void btnLoginOnClick(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
