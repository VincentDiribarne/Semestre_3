package com.example.uno;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilLogin extends AppCompatActivity {
    private Button playDevice, playOnline, rules, scores;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playDevice.findViewById(R.id.play_on_this_device);
        playOnline.findViewById(R.id.play_online);
        rules.findViewById(R.id.rules);
        scores.findViewById(R.id.scores);

        playDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerPersonnage();
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void creerPersonnage() {

    }
}
