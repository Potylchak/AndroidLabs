package com.example.potylchak.lab4;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AudioActivity extends Activity {

    MediaPlayer mPlayer;
    Button startButton, pauseButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_audio);

        mPlayer=MediaPlayer.create(this, R.raw.music);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        startButton = (Button) findViewById(R.id.start);

        pauseButton = (Button) findViewById(R.id.pause);

        stopButton = (Button) findViewById(R.id.stop);

        pauseButton.setEnabled(false);

        stopButton.setEnabled(false);
    }

    private void stopPlay(){

        mPlayer.stop();

        pauseButton.setEnabled(false);

        stopButton.setEnabled(false);

        try {

            mPlayer.prepare();

            mPlayer.seekTo(0);

            startButton.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view){

        mPlayer.start();

        startButton.setEnabled(false);

        pauseButton.setEnabled(true);

        stopButton.setEnabled(true);
    }
    public void pause(View view){

        mPlayer.pause();

        startButton.setEnabled(true);

        pauseButton.setEnabled(false);

        stopButton.setEnabled(true);
    }
    public void stop(View view){

        stopPlay();
    }
    @Override
    public void onDestroy() {

        super.onDestroy();

        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }
}
