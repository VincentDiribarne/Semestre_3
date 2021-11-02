package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView lumiereTextView;
    public CapteurManager capteurManager;
    public ImageView imageViewBille;
    public ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lumiereTextView = findViewById(R.id.lumiereTextView);
        imageViewBille = findViewById(R.id.billeImageView);
        layout = findViewById(R.id.layout);

        capteurManager = new CapteurManager(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasfocus) {
        super.onWindowFocusChanged(hasfocus);
        View decorView = getWindow().getDecorView();
        if (hasfocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        capteurManager.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        capteurManager.stop();
    }

    public void bureau() {
        Intent bureau = new Intent(Intent.ACTION_MAIN);
        bureau.addCategory(Intent.CATEGORY_HOME);
        bureau.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(bureau);
    }
}