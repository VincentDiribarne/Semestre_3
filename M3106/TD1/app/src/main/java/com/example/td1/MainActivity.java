package com.example.td1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


//Firebase
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button bouton;
    private EditText editText;
    private String pseudo;
    private ImageButton deconnection;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView messageRecyclerView;
    public DatabaseReference databaseReference;

    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView dataPseudoTextView;
        TextView dataMessageTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            dataMessageTextView = itemView.findViewById(R.id.dataMessageTextView);
            dataPseudoTextView = itemView.findViewById(R.id.dataPseudoTextView);
        }
    }

    public FirebaseRecyclerAdapter<Message, MessageViewHolder> firebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton = findViewById(R.id.button);
        editText = findViewById(R.id.editTextMessage);
        deconnection = findViewById(R.id.disconnect);

        //Instantiation Linear View
        messageRecyclerView = findViewById(R.id.recyclerViewFirebase);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        messageRecyclerView.setLayoutManager(linearLayoutManager);

        firebaseAuthentification();

        //Bouton click
        boutonClick();

        //Bouton envoi clavier
        envoiClavier();


        deconnection.setOnClickListener(v -> {
            SignInActivity sign = new SignInActivity();
            sign.signOut();
        });


        //Firebase
        messageRecyclerView.setAdapter(firebaseAdapter);
        databaseReference = FirebaseDatabase.getInstance("https://hyper-chat-iut-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        SnapshotParser<Message> parser = snapshot -> {
            Message message = snapshot.getValue(Message.class);
            if (message != null) {
                message.setId(snapshot.getKey());
            }
            return message;
        };

        //Recupération des messages depuis Firebase
        FirebaseRecyclerOptions<Message> options = new FirebaseRecyclerOptions.Builder<Message>().setQuery(databaseReference.child("Message du Chat"), parser).build();
        firebaseAdapter = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {

            @Override
            public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                return new MessageViewHolder(inflater.inflate(R.layout.item_message, viewGroup, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull final MessageViewHolder viewHolder, int position, @NonNull Message message) {
                viewHolder.dataMessageTextView.setText(message.getText());
                viewHolder.dataPseudoTextView.setText(message.getNom());
            }
        };

        messageRecyclerView.setAdapter(firebaseAdapter);

        firebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                messageRecyclerView.scrollToPosition(positionStart);
            }
        });
    }

    public void firebaseAuthentification() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser == null) {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            pseudo = firebaseUser.getDisplayName();
        }
    }


    public void createTextChat() {
        String texte = editText.getText().toString();

        //BDD
        Message message = new Message(pseudo, texte);
        if (message.getText().equals("/clear")) {
            if (pseudo.equals("Vincent Diribarne")) {
                databaseReference.child("Message du Chat").setValue(null);
            }
            editText.setText("");
            return;
        }
        databaseReference.child("Message du Chat").push().setValue(message);
        editText.setText("");
    }


    public void boutonClick() {
        bouton.setOnClickListener(v -> {
            if (editText.getText().toString().isEmpty()) {
                editText.setError("Ajoutez un message !");
                return;
            }
            createTextChat();
            //Toast.makeText(getApplicationContext(), "Votre texte a été ajouté", Toast.LENGTH_LONG).show();
        });
    }

    public void envoiClavier() {
        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                if (editText.getText().toString().isEmpty()) {
                    editText.setError("Ajoutez un message !");
                    return false;
                }
                createTextChat();
            }
            return false;
        });
    }

    public void onPause() {
        firebaseAdapter.stopListening();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        firebaseAdapter.startListening();
    }
}