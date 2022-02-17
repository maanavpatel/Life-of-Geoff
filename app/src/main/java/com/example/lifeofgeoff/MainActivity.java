package com.example.lifeofgeoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener lifeWith = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("life with geoff selected");
                Intent camera = new Intent(view.getContext(), GeoffActivity.class);
                camera.putExtra("countFaces", true);
                startActivity(camera);
            }
        };
        Button lifeWG = findViewById(R.id.lifeWithGeoff);
        lifeWG.setOnClickListener(lifeWith);


        View.OnClickListener byow = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Build your own world selected");
                Intent settings = new Intent(view.getContext(), SettingsActivity.class);
                startActivity(settings);
            }
        };
        Button build = findViewById(R.id.buildYourOwn);
        build.setOnClickListener(byow);
    }
}
