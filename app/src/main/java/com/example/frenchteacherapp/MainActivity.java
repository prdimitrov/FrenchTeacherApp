package com.example.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button blackButton, greenButton, redButton, yellowButton, purpleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            blackButton = findViewById(R.id.buttonBlack);
            greenButton = findViewById(R.id.buttonGreen);
            redButton = findViewById(R.id.buttonRed);
            yellowButton = findViewById(R.id.buttonYellow);
            purpleButton = findViewById(R.id.buttonPurple);

            redButton.setOnClickListener(v1 -> {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.red);

                mediaPlayer.start();
            });
            return insets;
        });
    }
}