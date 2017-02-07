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

public class MainActivity extends AppCompatActivity {

    EditText edtLoginName;
    EditText edtPassword;
    CheckBox chkStayLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLoginName = (EditText) findViewById(R.id.edtLoginName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
    }

    public void btnLoginOnClick(View v) {
//        Log.i("CLICK", "Login button was clicked");
//        Log.i( "CLICK", edtLoginName.getText().toString());
        finish();
        Intent intent = new Intent(this, Landing1.class);
        Toast.makeText(this, "You successfully logged in: " + edtLoginName.getText().toString() +
                "\nYour Password is: " + edtPassword.getText().toString(), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

    public void btnCancelOnClick(View v) {
//        Log.i("CLICK", "Cancel was clicked");
        edtLoginName.setText("");
        edtPassword.setText("");
        Toast.makeText(this, "Login has been canceled", Toast.LENGTH_LONG).show();
    }
}
