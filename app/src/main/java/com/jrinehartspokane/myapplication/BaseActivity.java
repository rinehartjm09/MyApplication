package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class BaseActivity extends AppCompatActivity {

    public GestureDetectorCompat gestureObject;
    protected Class[] landingPages = {
            MainActivity.class,
            Landing1.class,
            Landing2.class,
            Landing3.class,
            Landing4.class,
            Landing5.class
    };
    static int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureObject = new GestureDetectorCompat(this, new BaseActivity.LearnGesture());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void btnLoginOnClick(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {
            Log.i("BMI", "X1: " + event1.getX() + " Y1: " + event1.getY());
            Log.i("BMI", "X2: " + event2.getX() + " Y2: " + event2.getY());
            Log.i("BMI: ", "VelocityX: " + velocityX);
            Log.i("BMI: ", "VelocityY: " + velocityY);

            if (event2.getX() > event1.getX()) {
                Log.i("BMI", "Left to Right Swipe");
                if (currentPage > 0) {
                    currentPage--;
                    finish();
                    startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
                }
            } else if (event2.getX() < event1.getX()) {
                Log.i("BMI", "Right to Left Swipe");
                if (currentPage < landingPages.length - 1) {
                    currentPage++;
                    finish();
                    startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
                }
            }
            Log.i("BMI", "Current page: " + currentPage);
            return true;
        }
    }
}
