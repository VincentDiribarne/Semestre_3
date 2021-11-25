package com.example.uno;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {
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

        playDevice.setOnClickListener(v -> {
            startActivity(new Intent(AccueilActivity.this, CreationActivity.class));
        });

        playOnline.setOnClickListener(v -> {
            Toast.makeText(AccueilActivity.this, "Pas encore fait, une future mise à jour", Toast.LENGTH_SHORT).show();
        });

        scores.setOnClickListener(v -> {
            startActivity(new Intent(AccueilActivity.this, ScoreActivity.class));
        });

        rules.setOnClickListener(v -> rules());

        profil.setOnClickListener(v -> {
            profil();
        });

        music.setOnClickListener(v -> {
            if (musicEnCours) {
                music.setImageResource(R.drawable.ic_audio_off_black);
                musicEnCours = false;
            } else {
                music.setImageResource(R.drawable.ic_audio_black);
                musicEnCours = true;
            }
        });
    }

    private void profil() {
        startActivity(new Intent(AccueilActivity.this, ProfilActivity.class));
    }

    public void rules() {
        new AlertDialog.Builder(this)
                .setTitle("Les règles")
                .setMessage("Jouez avec vos amis sur le même téléphone. Utilisez vos cartes placées devant vous, et faites votre possible pour vous en débarrasser." +
                        " Il faut que la carte soit de la même couleur, ou du même type que la carte placée sur le paquet." + " Vous ne pouvez pas poser de carte, il faut piocher dans ce cas." +
                        " S'il vous reste une carte dans votre main, pensez à dire UNO, ou vous aurez de mauvaise surprise de la part de vos adversaires. La partie s'arrête quand un des joueurs n'a plus de carte.")
                .setIcon(R.drawable.uno_logo)
                .setPositiveButton(R.string.compris, (dialog, which) -> {

                })
                .show();
    }
}
