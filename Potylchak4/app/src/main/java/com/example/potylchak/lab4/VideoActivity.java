package com.example.potylchak.lab4;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    VideoView videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video);

        videoPlayer =  (VideoView)findViewById(R.id.videoPlayer);

        videoPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.video));

        MediaController mediaController = new MediaController(this);

        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);
    }

}
