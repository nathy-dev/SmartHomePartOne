package com.example.smarthomepartone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoReview extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_review);

       final Button practiceButton = findViewById(R.id.button2);
       final Button replayButton = (Button) findViewById(R.id.button3);

        Bundle bundle = getIntent().getExtras();
        String data = bundle.get("data").toString();

        String videoPath;

        switch (data) {
            case "Turn on Lights":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.light_on;
                break;
            case "Turn off Lights":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.light_off;
                break;
            case "Turn on Fan":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fan_on;
                break;
            case "Turn off Fan":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fan_off;
            case "Increase Fan Speed":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.increase_fan_speed;
                break;
            case "Decrease Fan Speed":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.decrease_fan_speed;
                break;
            case "Set Thermostat to Specified Temperature":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.set_thermo;
                break;
            case "0":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num0;
                break;
            case "1":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num1;
                break;
            case "2":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num2;
                break;
            case "3":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num3;
                break;
            case "4":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num4;
                break;
            case "5":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num5;
                break;
            case "6":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num6;
                break;
            case "7":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num7;
                break;
            case "8":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num8;
                break;
            case "9":
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num9;
                break;
            default:
                videoPath = "android.resource://" + getPackageName() + "/" + R.raw.num0;
                break;

        }


        VideoView videoView = findViewById(R.id.video_view);
        Uri uri =  Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.start();



        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();

            }
        });

        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoReview.this, GestureRecord.class);
                intent.putExtra("data", data);
                startActivity(intent);
                }
            });




    }


}