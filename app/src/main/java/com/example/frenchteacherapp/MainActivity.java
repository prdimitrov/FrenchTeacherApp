package com.example.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

            blackButton.setOnClickListener(this);
            greenButton.setOnClickListener(this);
            redButton.setOnClickListener(this);
            yellowButton.setOnClickListener(this);
            purpleButton.setOnClickListener(this);

            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonBlack) {
            playSounds(R.raw.black);
        } else if (v.getId() == R.id.buttonGreen) {
            playSounds(R.raw.green);
        } else if (v.getId() == R.id.buttonRed) {
            playSounds(R.raw.red);
        } else if (v.getId() == R.id.buttonYellow) {
            playSounds(R.raw.yellow);
        } else if (v.getId() == R.id.buttonPurple) {
            playSounds(R.raw.purple);
        }
    }

    private void playSounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}