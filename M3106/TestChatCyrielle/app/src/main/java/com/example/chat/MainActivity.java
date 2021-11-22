package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView editText;
    private EditText editTextModif;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.Modification);
        editTextModif = findViewById(R.id.editTextModif);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextModif.getText().toString().isEmpty()) {
                    editTextModif.setError("Entrez un message");
                } else {
                    editText.setText(editTextModif.getText().toString());
                }
            }
        });
    }


}