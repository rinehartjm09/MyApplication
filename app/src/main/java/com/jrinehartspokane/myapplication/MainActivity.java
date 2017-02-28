package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        username = edtLoginName.getText().toString();
        password = edtPassword.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://caasera.azurewebsites.net/api/1.0/student";
        // Request string from url
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ToastIt(getString(com.jrinehartspokane.myapplication.R.string.loggedIn) + edtLoginName.getText().toString() +
                                getString(R.string.Password) + edtPassword.getText().toString());
                        finish();
                        currentPage = 1;
                        startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("BMI", "Login error: " + error.networkResponse.statusCode);
                        ToastIt(getString(R.string.properCredentials));
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                String credentials = username + ":" + password;
                String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                Log.i("BMI", auth);
                headers.put("Authorization", auth);
                return headers;
            }
        };
        queue.add(jsonRequest);
    }

    public void btnCancelOnClick(View v) {
        edtLoginName.setText("");
        edtLoginName.requestFocus();
        edtPassword.setText("");
        ToastIt(getString(R.string.loginCanceled));
    }
}
