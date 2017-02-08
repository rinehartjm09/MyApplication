package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    EditText edtLoginName;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLoginName = (EditText) findViewById(R.id.edtLoginName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
    }

    public void btnMainLoginOnClick(View v) {
        finish();
        currentPage = 1;
        startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
        ToastIt("You successfully logged in: " + edtLoginName.getText().toString() +
                "\nYour Password is: " + edtPassword.getText().toString());
    }

    public void btnCancelOnClick(View v) {
        edtLoginName.setText("");
        edtLoginName.requestFocus();
        edtPassword.setText("");
        ToastIt("Login has been canceled");
    }
}
