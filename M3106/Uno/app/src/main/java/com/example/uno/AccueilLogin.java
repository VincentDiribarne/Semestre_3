package com.example.uno;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilLogin extends AppCompatActivity {
    Button playDevice, playOnline, rules, scores;
    ImageView music, profil;
    Boolean musicEnCours;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playDevice = findViewById(R.id.play_on_this_device);
        playOnline = findViewById(R.id.play_online);
        rules = findViewById(R.id.rules);
        scores = findViewById(R.id.scores);
        music = findViewById(R.id.music);
        profil = findViewById(R.id.profil);
        musicEnCours = true;


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

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicEnCours) {
                    music.setImageResource(R.drawable.ic_audio_off_black);
                    musicEnCours = false;
                } else {
                    music.setImageResource(R.drawable.ic_audio_black);
                    musicEnCours = true;
                }
            }
        });
    }

    public void creerPersonnage() {
        new AlertDialog.Builder(this)
                .setTitle("Guide d'utilisation")
                .setMessage("Dans ce jeu, un pokémon va vous être présenté, vous aurez quatre propositions dont une contenant le véritable nom de celui-ci ! A vous de le retrouver et de cliquer dessus jeune dresseur ! Attention cependant," +
                        " vous serez chronométré et n'aurez que 3 possibilités d'échouer !")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .show();
    }
}
