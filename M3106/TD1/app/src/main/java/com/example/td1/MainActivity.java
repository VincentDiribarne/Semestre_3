package com.example.td1;

import androidx.annotation.NonNull;
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

import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private EditText editText;
    private LinearLayout container;
    private EditText pseudo;

    public DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.button);
        editText = findViewById(R.id.editTextMessage);
        container = findViewById(R.id.container);
        pseudo = findViewById(R.id.pseudo);

        //Bouton click
        bouton.setOnClickListener(v -> {
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
        });

        //Bouton envoi clavier
        editText.setOnEditorActionListener((v, actionId, event) -> {
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
        });

        //Firebase
        databaseReference = FirebaseDatabase.getInstance("https://hyper-chat-iut-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        SnapshotParser<Message> parser = snapshot -> {
            Message message = snapshot.getValue(Message.class);
            if (message != null) {
                message.setId(snapshot.getKey());
            }
            return message;
        };
    }

    public void createTextChat() {
        //New Text View
        TextView editTextAdd = new TextView(this);
        container.addView(editTextAdd);
        editTextAdd.setTextSize(20);

        String auteur = pseudo.getText().toString();
        String texte = editText.getText().toString();

        //BDD
        Message message = new Message(auteur, texte);
        databaseReference.child("Message du Chat").push().setValue(message);

        //Envoi et reset
        editTextAdd.setText(auteur + " : " + texte);
        editText.setText("");
    }
}