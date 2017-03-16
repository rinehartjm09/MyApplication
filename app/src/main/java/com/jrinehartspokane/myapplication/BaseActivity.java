package com.jrinehartspokane.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class BaseActivity extends AppCompatActivity {


    //New Gesture object
    public GestureDetectorCompat gestureObject;

    //Array of different activities
    protected Class[] landingPages = {
            MainActivity.class,
            LessonHomeActivity.class,
            Playground.class,
            Landing1.class,
            Landing2.class,
            Landing3.class,
            Landing4.class,
            Landing5.class
    };

    //Set currentPage to 0 initially
    public static int currentPage = 0;
    static String username = "";
    static String password = "";
    static StudentInfo studentInfo;

    //Login buttons on activity pages. Not main activity method
    public void btnLoginOnClick(View v) {
        finish();
        currentPage = 0;
        startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
    }

    public void btnFreeTrialOnClick(View v) {
        finish();
//        currentPage = 0;
        startActivity(new Intent(getApplicationContext(), FreeTrial.class));
    }

    //ToastIt method to print to the screen
    public void ToastIt(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    //Creating onCreate method for BaseActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureObject = new GestureDetectorCompat(this, new BaseActivity.LearnGesture());
    }

    //onTouch event for swiping pages
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //Gesture detector for swiping through pages
    class LearnGesture extends GestureDetector.SimpleOnGestureListener {

        //onFling for detecting a swiping event
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            //Left to right swipe motion
            if (event2.getX() > event1.getX()) {
                if (currentPage > 0) {
                    currentPage--;
                    finish();
                    startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
                }

                //Right to Left swipe motion
            } else if (event2.getX() < event1.getX()) {
                if (currentPage < landingPages.length - 1) {
                    currentPage++;
                    finish();
                    startActivity(new Intent(getApplicationContext(), landingPages[currentPage]));
                }
            }
            return true;
        }
    }
}
