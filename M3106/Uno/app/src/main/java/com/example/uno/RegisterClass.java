package com.example.uno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterClass extends AppCompatActivity {
    /*

    private static final String TAG = "";
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    TextView goToLogin;
    EditText mailEditText, passwordEditText, confirmPasswordEditText;
    Button registerButton;
    String mailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        goToLogin = findViewById(R.id.register_text_view);
        mailEditText = findViewById(R.id.mail_edit_text);
        passwordEditText = findViewById(R.id.password1_edit_text);
        confirmPasswordEditText = findViewById(R.id.password2_edit_text);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerForAuth();
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }


    private void PerForAuth() {
        String mail = mailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        if (!mail.matches(mailPattern)) {
            mailEditText.setError("Enter Correct Email");
            return;
        }

        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("Enter proper password");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("les mots de passe ne sont pas identiques");
        } else {
            mAuth.createUserWithEmailAndPassword(mail, password)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            sendUserToNextActivity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    });
        }
    }


    private void sendUserToNextActivity() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }


    private void updateUI(GoogleSignInAccount account) {
        if (account != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }*/
}
