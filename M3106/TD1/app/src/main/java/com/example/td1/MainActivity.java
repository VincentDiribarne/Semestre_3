package com.example.td1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private EditText editText;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editTextMessage);
        container = (LinearLayout) findViewById(R.id.container);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Toast.makeText(getApplicationContext(), "Votre texte a été ajouté", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onBackPressed() {
        TextView editTextAjout = new TextView(this);
        container.addView(editTextAjout);
        editTextAjout.setTextSize(25);
        editTextAjout.setText(editText.getText());
    }

}