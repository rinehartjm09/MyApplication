package com.jrinehartspokane.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class FreeTrial extends AppCompatActivity {
    WebView wvFreeTrial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_trial);
        wvFreeTrial = (WebView) findViewById(R.id.wvFreeTrial);
        wvFreeTrial.loadUrl("https://www.google.com");
    }
}
