package com.example.td1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private EditText editText;
    private LinearLayout container;
    private EditText pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.button);
        editText = findViewById(R.id.editTextMessage);
        container = findViewById(R.id.container);
        pseudo = findViewById(R.id.pseudo);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pseudo.getText().toString().isEmpty()) {
                    pseudo.setError("Ajoutez un pseudo !");
                    return;
                }

                if (editText.getText().toString().isEmpty()) {
                    editText.setError("Ajoutez un message !");
                    return;
                }
                createTextChat();
                Toast.makeText(getApplicationContext(), "Votre texte a été ajouté", Toast.LENGTH_LONG).show();
            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    if (pseudo.getText().toString().isEmpty()) {
                        pseudo.setError("Ajoutez un pseudo !");
                        return false;
                    }

                    if (editText.getText().toString().isEmpty()) {
                        editText.setError("Ajoutez un message !");
                        return false;
                    }
                    createTextChat();
                    Toast.makeText(getApplicationContext(), "Votre texte a été ajouté", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
    }

    public void createTextChat() {
        TextView editTextAdd = new TextView(this);
        container.addView(editTextAdd);
        editTextAdd.setTextSize(20);
        editTextAdd.setText(pseudo.getText() + " : " + editText.getText());
        pseudo.setText("");
        editText.setText("");
    }

}