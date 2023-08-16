package com.kplo.olplantd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class AIActivity extends AppCompatActivity {

    private ImageButton btn_to_camera;
    private ImageButton btn_to_Album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aiactivity);

        btn_to_camera = (ImageButton) findViewById(R.id.ImageButton_Camera);
        btn_to_camera.setOnClickListener(v -> {
            Intent intent = new Intent(AIActivity.this, AICameraActivity.class);
            startActivity(intent);
        });

        btn_to_Album = (ImageButton) findViewById(R.id.ImageButton_Album);
        btn_to_Album.setOnClickListener(v -> {
            Intent intent = new Intent(AIActivity.this, AIAlbumActivity.class);
            startActivity(intent);
        });
    }

}