package com.jrinehartspokane.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Landing2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing2);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        //MediaController mediaController = new MediaController(this);
        // mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);

//        videoView.setVideoPath("/sdcard/blonde_secretary.3gp");
//        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_file;
//        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }
}
